package com.abt.mvp.data.db;

import com.abt.mvp.app.MvpApplication;
import com.abt.mvp.data.dao.DaoSession;
import com.abt.mvp.data.dao.HistoryData;
import com.abt.mvp.data.dao.HistoryDataDao;

import java.util.Iterator;
import java.util.List;

/**
 * @描述： @DbHelperImpl
 * @作者： @黄卫旗
 * @创建时间： @06/06/2018
 */
public class DbHelperImpl implements DbHelper {

    private DaoSession daoSession;

    //@Inject
    public DbHelperImpl() {
        daoSession = ((MvpApplication)MvpApplication.getAppContext()).getDaoSession();
    }

    @Override
    public List<HistoryData> addHistoryData(String data) {
        HistoryDataDao historyDataDao = daoSession.getHistoryDataDao();
        List<HistoryData> historyDataList = historyDataDao.loadAll();
        HistoryData historyData = new HistoryData();
        historyData.setDate(System.currentTimeMillis());
        historyData.setData(data);
        //重复搜索时进行历史记录前移
        Iterator<HistoryData> iterator = historyDataList.iterator();
        //不要在foreach循环中进行元素的remove、add操作，使用Iterator模式
        while (iterator.hasNext()) {
            HistoryData historyData1 = iterator.next();
            if (historyData1.getData().equals(data)) {
                historyDataList.remove(historyData1);
                historyDataList.add(historyData);
                historyDataDao.deleteAll();
                historyDataDao.insertInTx(historyDataList);
                return historyDataList;
            }
        }
        if (historyDataList.size() < 10) {
            historyDataDao.insert(historyData);
        } else {
            historyDataList.remove(0);
            historyDataList.add(historyData);
            historyDataDao.deleteAll();
            historyDataDao.insertInTx(historyDataList);
        }
        return historyDataList;
    }

    @Override
    public void clearHistoryData() {
        HistoryDataDao historyDataDao = daoSession.getHistoryDataDao();
        historyDataDao.deleteAll();
    }


}
