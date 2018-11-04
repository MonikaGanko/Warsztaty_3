package pl.coderslab.dao;

import pl.coderslab.model.Status;
import pl.coderslab.model.Vehicle;
import pl.coderslab.service.DbService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StatusDao {

    public static Status findById(int id){
        List<String> params = new ArrayList<>();
        params.add(String.valueOf(id));
        List<Status> list = prepareStatuses("SELECT status_id, description FROM statuses WHERE status_id=?",params);
        if(list!=null && list.size()>0) {
            return list.get(0);
        }
        return null;
    }

    public static List<Status> findAll(){
        return prepareStatuses("SELECT status_id, description FROM statuses",null);
    }

    private static List<Status> prepareStatuses(String q, List<String> params){
        List<Status> statuses = null;
        try {
            List<String[]> list = DbService.getData(q,params);
            statuses = new ArrayList<>();
            for(String[] item: list){
                Status statusItem = new Status();
                statusItem.setStatusId(Integer.parseInt(item[0]));
                statusItem.setDescription(item[1]);

                statuses.add(statusItem);
            }
            return statuses;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statuses;
    }
}
