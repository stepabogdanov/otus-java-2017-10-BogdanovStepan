package connnection;

import base.DBService;
import com.mysql.cj.x.protobuf.MysqlxCrud;

import java.sql.Connection;

public class DBServiceConnection implements DBService {
    private final Connection connection;
    public DBServiceConnection()

    @Override
    public String getMetaData() {
        return null;
    }

    @Override
    public void close() throws Exception {

    }
}
