package vehicle;
/**
 * @author Yi Chen
 */
import java.sql.*;
import java.util.Random;

/**
 * main class
 *
 */
public class Main {
    static Connection con;


    /**
     * main method
     * @param args to call the main function in java. The main method is called if it’s formal parameter matches that of an array of Strings.
     */
    public static void main(String[] args) {
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:vehicle.db");

            // create table if not exists
            String ctreateTable="create table if not exists vehicle(name varchar(50),type varchar (50)," +
                    "pedal varchar (50),steeringwheel varchar (50),direction varchar (50)," +
                    "speed double,x double,y double,z double)";
            Statement createStatement = con.createStatement();
            long f1 = createStatement.executeUpdate(ctreateTable);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Main main = new Main();
        System.out.println("---------------------------------------------------------------------------------------");
        main.moveLandVehicle("Toyota");
        System.out.println("---------------------------------------------------------------------------------------");
        main.moveLandVehicle("Volkswagen");
        System.out.println("---------------------------------------------------------------------------------------");
        main.moveLandVehicle("Ford");
        System.out.println("---------------------------------------------------------------------------------------");
        main.moveAirVehicle("Boeing");
        System.out.println("---------------------------------------------------------------------------------------");
        main.moveAirVehicle("Airbus");
        System.out.println("---------------------------------------------------------------------------------------");
        main.moveAirVehicle("Bombardier");
        System.out.println("---------------------------------------------------------------------------------------");
        main.moveMotorcycles("Yamaha");
        System.out.println("----------------------------------------------------------------------------------------");
        main.moveSAMs ("Misil");
        System.out.println("----------------------------------------------------------------------------------------");

    }

    /**
     * make sure the vehicle starts from the last ending
     * @param vehicle
     */
    public boolean queryLastEnding(Vehicle vehicle) {
        try {
            String selectSql = "select name, type, pedal, steeringwheel, direction, speed, x, y, z from vehicle where name = '" + vehicle.getName() + "'";
            PreparedStatement prepareStatement = con.prepareStatement(selectSql);
            ResultSet rs = prepareStatement.executeQuery();

            boolean hasData = false;
            // only one data for each vehicle
            while (rs.next()) {
                String name = rs.getString(1);
                String type = rs.getString(2);
                String pedal = rs.getString(3);
                String steeringWheel = rs.getString(4);
                String direction = rs.getString(5);
                double speed = rs.getDouble(6);
                double x = rs.getDouble(7);
                double y = rs.getDouble(8);
                double z = rs.getDouble(9);
                System.out.println("last ending for vehicle " + name + ", type: " + type + " pedal: " + pedal + " steeringWheel: " + steeringWheel + " direction: " + direction + " speed: " + speed + " x: " + x + " y: " + y + " z: " + z);
                vehicle.setPedal(pedal != null && !pedal.equals("null") ? Pedal.valueOf(pedal) : null);
                vehicle.setSteeringWheel(steeringWheel != null && !steeringWheel.equals("null")  ? SteeringWheel.valueOf(steeringWheel) : null);
                vehicle.setDirection(direction != null && !direction.equals("null")  ? Direction.valueOf(direction) : null);
                vehicle.setSpeed(speed);
                vehicle.setPosition(new Position(x, y, z));
                hasData = true;
            }
            return hasData;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    /**
     * insert vehicle info
     * @param vehicle
     */
    public void insertVehicleInfo(Vehicle vehicle) {
        try {
            String insertSql = "insert into vehicle (name, type, pedal, steeringwheel, direction, speed, x, y, z) values('" +
                    vehicle.getName() + "', '" + vehicle.getType() + "', '" + vehicle.getPedal() + "', '" + vehicle.getSteeringWheel() + "', '" + vehicle.getDirection() + "', '" +
                    vehicle.getSpeed() + "', '" + vehicle.getPosition().getX() + "', '" + vehicle.getPosition().getY() + "', '" + vehicle.getPosition().getZ() + "')";
            Statement insertStatement = con.createStatement();
            long insertCount = insertStatement.executeUpdate(insertSql);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * update vehicle info
     * @param vehicle
     */
    public void updateVehicleInfo(Vehicle vehicle) {
        try {
            String updateSql = "update vehicle set pedal = '" + vehicle.getPedal() + "', steeringwheel = '" + vehicle.getSteeringWheel() + "', direction = '" + vehicle.getDirection() + "', " +
                    "speed = '" + vehicle.getSpeed() + "', x = '" + vehicle.getPosition().getX() + "', y = '" + vehicle.getPosition().getY() + "', z = '" + vehicle.getPosition().getZ() + "' " +
                    "where name = '" + vehicle.getName() + "' and type = '" + vehicle.getType() + "'";
            Statement updateStatement = con.createStatement();
            long updateCount = updateStatement.executeUpdate(updateSql);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * move LandVihicle for 10 actions
     * @param name give name
     */
    public void moveLandVehicle(String name) {
        Vehicle vehicle = new LandVehicle("LandVehicle", name);

        // starts from the last ending
        boolean hasData = this.queryLastEnding(vehicle);
        for (int i = 0; i < 10; i++) {
            Random random = new Random();
            double randomGasPedalSpeed = random.nextInt(40);
            double randomBrakePedalSpeed = random.nextInt(40);
            int randomPedal = new Random().nextInt(Pedal.values().length);
            Pedal pedal = Pedal.values()[randomPedal];
            int randomSteeringWheel = new Random().nextInt(SteeringWheel.values().length);
            SteeringWheel steeringWheel = SteeringWheel.values()[randomSteeringWheel];
            vehicle.move(pedal, randomGasPedalSpeed, randomBrakePedalSpeed, 0, steeringWheel, Direction.STRAIGHT);

            // store vehicle into db
            if (hasData) { // update the existing data
                this.updateVehicleInfo(vehicle);
            } else { // insert the first data
                this.insertVehicleInfo(vehicle);
                hasData = true;
            }
            System.out.println(vehicle.toString());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * move AirVihicle for 10 actions
     * @param name give name
     */
    public void moveAirVehicle(String name) {
        Vehicle vehicle = new AirVehicle("AirVehicle", name);

        // starts from the last ending
        boolean hasData = this.queryLastEnding(vehicle);
        for (int i = 0; i < 10; i++) {
            Random random = new Random();
            double propellerSpeed = random.nextInt(20) - 10;
            int randomSteeringWheel = new Random().nextInt(SteeringWheel.values().length);
            SteeringWheel steeringWheel = SteeringWheel.values()[randomSteeringWheel];
            // int randomDirection = new Random().nextInt(Direction.values().length);
            int randomDirection = i % 3;
            Direction direction = Direction.values()[randomDirection];
            vehicle.move(null, 0, 0, propellerSpeed, steeringWheel, direction);

            // store vehicle into db
            if (hasData) { // update the existing data
                this.updateVehicleInfo(vehicle);
            } else { // insert the first data
                this.insertVehicleInfo(vehicle);
                hasData = true;
            }
            System.out.println(vehicle.toString());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void moveMotorcycles(String name){
        LandVehicle landVehicle = new Motorcycles("Yamaha", name);

        // starts from the last ending
        boolean hasData = this.queryLastEnding(landVehicle);
        for (int i = 0; i < 10; i++) {
            Random random = new Random();
            double randomGasPedalSpeed = random.nextInt(40);
            double randomBrakePedalSpeed = random.nextInt(40);
            int randomPedal = new Random().nextInt(Pedal.values().length);
            Pedal pedal = Pedal.values()[randomPedal];
            int randomSteeringWheel = new Random().nextInt(SteeringWheel.values().length);
            SteeringWheel steeringWheel = SteeringWheel.values()[randomSteeringWheel];
            if (landVehicle.getCanMove()) {
                landVehicle.move(pedal, randomGasPedalSpeed, randomBrakePedalSpeed, 0, steeringWheel, Direction.STRAIGHT);

                // store vehicle into db
                if (hasData) { // update the existing data
                    this.updateVehicleInfo(landVehicle);
                } else { // insert the first data
                    this.insertVehicleInfo(landVehicle);
                    hasData = true;
                }
            }
            System.out.println(landVehicle.toString());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void moveSAMs(String name) {
        AirVehicle airVehicle = new SAMs("Misil", name);

        // starts from the last ending
        boolean hasData = this.queryLastEnding(airVehicle);
        for (int i = 0; i < 10; i++) {
            Random random = new Random();
            double propellerSpeed = random.nextInt(20) - 10;
            int randomSteeringWheel = new Random().nextInt(SteeringWheel.values().length);
            SteeringWheel steeringWheel = SteeringWheel.values()[randomSteeringWheel];
            // int randomDirection = new Random().nextInt(Direction.values().length);
            int randomDirection = i % 3;
            Direction direction = Direction.values()[randomDirection];
            airVehicle.move(null, 0, 0, propellerSpeed, steeringWheel, direction);

            // store vehicle into db
            if (hasData) { // update the existing data
                this.updateVehicleInfo(airVehicle);
            } else { // insert the first data
                this.insertVehicleInfo(airVehicle);
                hasData = true;
            }
            System.out.println(airVehicle.toString());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * start a thread to move weapons every 5s
     * @param vehicle
     */
    public void scheduleMove(Vehicle vehicle) {
        final long timeInterval = 5000;
        Runnable runnable = new Runnable() {
            public void run() {
                while (true) {
                    switch (vehicle.getType()) {
                        case "LandVehicle":
                            moveLandVehicle(vehicle.getName());
                            break;
                        case "AirVehicle":
                            moveAirVehicle(vehicle.getName());
                            break;
                    }
                    try {
                        Thread.sleep(timeInterval);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }


}