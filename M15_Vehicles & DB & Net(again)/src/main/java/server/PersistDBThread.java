package server;

import org.lwjglb.engine.items.GameItem;

import java.io.*;
import java.net.Socket;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

class PersistDBThread implements Runnable {
    static Connection con;
    private Socket socket = null;
    private byte[] buffer = new byte[512];

    public PersistDBThread(Connection con, Socket socket) {
        this.con = con;
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream is = socket.getInputStream();
            is.read(buffer);
            String shapeData = new String(buffer);
            if (shapeData != null) {
                String[] shapeDataArray = shapeData.split(",");
                String messageType = shapeDataArray[0];
                String tid = shapeDataArray[1];
                float x = Float.parseFloat(shapeDataArray[2]);
                float y = Float.parseFloat(shapeDataArray[3]);
                float z = Float.parseFloat(shapeDataArray[4]);
                boolean existing = this.existingVehicleInfo(tid);
                if (!existing) {
                    this.insertVehicleInfo(tid, x, y, z);
                } else {
                    this.updateVehicleInfo(tid, x, y, z);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public boolean existingVehicleInfo(String tid) {
        try {
            String querySql = "select count(*) rowcount from vehicle " +
                    "where tid = '" + tid + "' ";;
            Statement queryStatement = con.createStatement();
            ResultSet rs = queryStatement.executeQuery(querySql);
            int count = rs.getInt("rowcount") ;
            if (count > 0) {
                return true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public void insertVehicleInfo(String tid, float x, float y, float z) {
        try {
            String insertSql = "insert into vehicle (tid, x, y, z) values('" + tid + "', '" + x + "', '" + y + "', '" + z + "')";
            Statement insertStatement = con.createStatement();
            long insertCount = insertStatement.executeUpdate(insertSql);
            System.out.println("insert: tid: " + tid + " x:" + x + " y:" + y + " z:" + z);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void updateVehicleInfo(String tid, float x, float y, float z) {
        try {
            String updateSql = "update vehicle set x = '" + x + "', y = '" + y  + "', z = '" + z + "' " +
                    "where tid = '" + tid + "' ";
            Statement updateStatement = con.createStatement();
            long updateCount = updateStatement.executeUpdate(updateSql);
            System.out.println("update: tid: " + tid + " x:" + x + " y:" + y + " z:" + z);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
