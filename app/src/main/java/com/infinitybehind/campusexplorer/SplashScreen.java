package com.infinitybehind.campusexplorer;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteReadOnlyDatabaseException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;


public class SplashScreen extends AppCompatActivity {

    SQLiteDatabase db = null;
    boolean dataBaseIsNotInitailised = true;
    ProgressBar pb;

    //    Initializing the database
    private void InitializeDataBase(){
        try{
            db= openOrCreateDatabase("campusExplorerDB",Context.MODE_PRIVATE,null);

            String createTableSQL = "create table if not exists campus_15(" +
                    "sno int(5) primary key," +
                    "place varchar(20) not null," +
                    "type varchar(10) not null," +
                    "latitude double(9,7) not null," +
                    "longitude double(9,7) not null," +
                    "floor int(5) not null," +
                    "name varchar(30)" +
                    ");";

            db.execSQL(createTableSQL);
            insertionQuerySet();

        }
        catch (SQLException ex){
            ex.printStackTrace();
        }

    }

    //Data Insertion

    private void insertionQuerySet(){

        if(db!=null){
            String querySet =
                    "insert into campus_15 values(0,'F-06','office',20.3482515,85.8159712,0,'BSP MISHRA');\n" +
                            "insert into campus_15 values(1,'C-1','classroom',20.34832,85.81611,0,NULL);\n" +
                            "insert into campus_15 values(2,'C-2','classroom',20.34818,85.81603,1,NULL);\n" +
                            "insert into campus_15 values(3,'C-3','classroom',20.34818,85.81603,0,NULL);\n" +
                            "insert into campus_15 values(4,'C-5','classroom',20.34799,85.81589,0,NULL);\n" +
                            "insert into campus_15 values(5,'C-6','classroom',20.34832,85.81611,1,NULL);\n" +
                            "insert into campus_15 values(6,'C-7','classroom',20.34833,85.81613,1,NULL);\n" +
                            "insert into campus_15 values(7,'C-8','classroom',20.34826,85.81611,1,NULL);\n" +
                            "insert into campus_15 values(8,'C-9','classroom',20.34834,85.81593,1,NULL);\n" +
                            "insert into campus_15 values(9,'C-10','classroom',20.34799,85.81589,1,NULL);\n" +
                            "insert into campus_15 values(10,'C-11','classroom',20.34799,85.81587,1,NULL);\n" +
                            "insert into campus_15 values(11,'C-17','classroom',20.34818,85.81603,2,NULL);\n" +
                            "insert into campus_15 values(12,'C-18','classroom',20.34818,85.81603,2,NULL);\n" +
                            "insert into campus_15 values(13,'DL-1','lab',20.34832,85.81611,0,NULL);\n" +
                            "insert into campus_15 values(14,'DL-2','lab',20.34832,85.81611,0,NULL);\n" +
                            "insert into campus_15 values(15,'DL-3','lab',20.34799,85.81592,0,'DAA LAB');\n" +
                            "insert into campus_15 values(16,'DL-4','lab',20.34799,85.81592,0,'NETWORKS LAB');\n" +
                            "insert into campus_15 values(17,'DL-5','lab',20.34799,85.81587,0,'IOT LAB');\n" +
                            "insert into campus_15 values(18,'DL-6','lab',20.34832,85.81611,1,NULL);\n" +
                            "insert into campus_15 values(19,'DL-7','lab',20.34832,85.81611,1,NULL);\n" +
                            "insert into campus_15 values(20,'LIBRARY','others',20.34832,85.81611,2,'LIBRARY');\n" +
                            "insert into campus_15 values(21,'DL-8','lab',20.34799,85.81592,1,'OS LAB');\n" +
                            "insert into campus_15 values(22,'DL-9','lab',20.34799,85.81592,1,'DATA ANALYTICS');\n" +
                            "insert into campus_15 values(23,'F-13','office',20.34797,85.81589,0,'ABHAYA KUMAR SAHOO');\n" +
                            "insert into campus_15 values(24,'F-107','office',20.34799,85.81587,1,'DEBASISH HATI');\n" +
                            "insert into campus_15 values(25,'F-108','office',20.3482037,85.8160808,1,'DR. CR PRADHAN');\n" +
                            "insert into campus_15 values(26,'F-109','office',20.3482037,85.8160808,1,'ANIL KUMAR SWAIN');\n" +
                            "insert into campus_15 values(27,'F-114','office',20.34832,85.81611,1,'GB MUND');\n" +
                            "insert into campus_15 values(28,'F-116','office',20.34821,85.81601,1,'LAXMAN SAHOO');\n" +
                            "insert into campus_15 values(29,'F-117','office',20.3482518,85.8159712,1,'PK PATTNAIK');\n" +
                            "insert into campus_15 values(30,'F-03','office',20.34836,85.81592,0,'SANTOSH SWAIN');\n" +
                            "insert into campus_15 values(31,'F-04','office',20.34836,85.81592,0,'AK JAGADEV');\n" +
                            "insert into campus_15 values(32,'F-02','office',20.34836,85.81592,0,'MANOJ KR MISHRA');\n" +
                            "insert into campus_15 values(33,'F-01','office',20.34836,85.81592,0,'KUMAR DEVDUTTA');\n" +
                            "insert into campus_15 values(34,'F-05','office',20.34836,85.81592,0,'HARISH PATTNAIK');\n" +
                            "insert into campus_15 values(35,'F-101','office',20.34836,85.81592,1,'SUBHASISH DASH');\n" +
                            "insert into campus_15 values(36,'F-106','office',20.3482518,85.8159712,1,'ARUP ABHINA ACHARYA');\n" +
                            "insert into campus_15 values(37,'F-105','office',20.3482518,85.8159712,1,'PRACHET BHUYAN');\n" +
                            "insert into campus_15 values(38,'F-102','office',20.3482518,85.8159712,1,'ANUJA KR ACHARYA');\n" +
                            "insert into campus_15 values(39,'F-103','office',20.3482518,85.8159712,1,'SUDAN JHA');\n" +
                            "insert into campus_15 values(40,'_','office',20.34836,85.81592,1,'SARITA TRIPATHY');\n" +
                            "insert into campus_15 values(41,'_','office',20.34836,85.81592,1,'BHASHWATI');\n" +
                            "insert into campus_15 values(42,'F-117','office',20.34836,85.81592,1,'ROSHNI PRADHAN');\n" +
                            "insert into campus_15 values(43,'Dean off','office',20.34834,85.81593,0,'SAMARESH MISHRA');\n" +
                            "insert into campus_15 values(44,'_','office',20.34834,85.81593,0,'SHELLY KUMAR KHUNTIA');\n" +
                            "insert into campus_15 values(46,'Room No. 18','others',20.34834,85.81593,1,'UG OFFICE');\n" +
                            "insert into campus_15 values(47,'Room No. 19','others',20.34797,85.81589,1,'CONFERENCE CELL');\n" +
                            "insert into campus_15 values(48,'Room No. 20','others',20.34800,85.81606,0,'ICT CELL');\n" +
                            "insert into campus_15 values(49,'Room No. 21','others',20.34800,85.81606,1,'TNP CELL');\n" +
                            "insert into campus_15 values(50,'F-204','office',20.34823,85.81595,1,'SK PANI');\n" +
                            "insert into campus_15 values(51,'F-09','office',20.3482037,85.8160808,0,'SC MOHARANA');\n" +
                            "insert into campus_15 values(52,'F-110','office',20.34802037,85.8160808,1,'RAJAT KUMAR BEHERA');\n" +
                            "insert into campus_15 values(53,'F-10','office',20.34819,85.81008,0,'SURESH CHANDRA SATPATHY');\n" +
                            "insert into campus_15 values(54,'F-11','office',20.34819,85.81008,0,'BISWAJIT SAHOO');\n" +
                            "insert into campus_15 values(55,'_','others',20.34818,85.81603,2,'CIRCULATION CELL');\n" +
                            "insert into campus_15 values(56,'Shop','others',20.34889,85.81536,0,'RAKESH SNACKS STALL');";

             String querySetArray[]=querySet.split("\n");
                for(String query : querySetArray){
                    try {
                        db.execSQL(query);
                    }catch (SQLException ex){
                        dataBaseIsNotInitailised=false;
                        return;
                    }
                }

            dataBaseIsNotInitailised=false;

        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        hideNavigationBar();
        transition();
        while (dataBaseIsNotInitailised){
            pb = (ProgressBar)findViewById(R.id.progressBar);
            InitializeDataBase();
        }
    }

    public void transition(){
        Thread t =  new Thread(){
            public void run(){
                try{
                    sleep(2000);

                }
                catch(Exception e){
                    System.out.println(e);
                }

                startActivity(new Intent(SplashScreen.this, MainActivity.class));
                finish();
            }
        };
        t.start();


    }

    public void hideNavigationBar() {
        this.getWindow().getDecorView().
                setSystemUiVisibility(
                        View.SYSTEM_UI_FLAG_FULLSCREEN |
                                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                );
    }

}

