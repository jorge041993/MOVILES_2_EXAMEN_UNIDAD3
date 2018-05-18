package com.example.george.examenu3;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener{

    private static final String TAG = "MainActivity";

    private SensorManager sensorManager;
    private Sensor accelerometer, mGyro, mMagno, mLight, mPressure, mTemp, mHumi;

    TextView xValue, yValue, zValue, xGyroValue, yGyroValue, zGyroValue, xMagnoValue, yMagnoValue, zMagnoValue, light,
    pressure, temp, humi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //vinculacion de variables
        xValue = (TextView)findViewById(R.id.xValue);
        yValue = (TextView)findViewById(R.id.yValue);
        zValue = (TextView)findViewById(R.id.zValue);

        //vinculacion de variables de giroscopio
        xGyroValue = (TextView)findViewById(R.id.xGyroValue);
        yGyroValue = (TextView)findViewById(R.id.yGyroValue);
        zGyroValue = (TextView)findViewById(R.id.zGyroValue);

        //vinculacion de variables del magnometro
        xMagnoValue= (TextView)findViewById(R.id.xMagnoValue);
        yMagnoValue = (TextView)findViewById(R.id.yMagnoValue);
        zMagnoValue = (TextView)findViewById(R.id.zMagnoValue);

        //vinculacion de variable de sensor de ligero
        light= (TextView)findViewById(R.id.light);

        //vinculacion de variable de sensor de presion
        pressure = (TextView)findViewById(R.id.pressure);

        //vinculacion de variable de sensor de temperatura
        temp = (TextView)findViewById(R.id.temp);

        //vinculacion de variable de sensor de humedad
        humi = (TextView)findViewById(R.id.humi);

        //el log determina un mensaje especifico
        Log.d(TAG, "onCreate: Initializing Sensor services");

        //Creamos el objeto para acceder al servicio de sensore
        sensorManager= (SensorManager)getSystemService(Context.SENSOR_SERVICE);

        //Método para parar la escucha del sensor acelerometro
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        if (accelerometer != null) {
            sensorManager.registerListener(MainActivity.this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);

            //el log determina un mensaje especifico
            Log.d(TAG, "onCreate: Registered accelerometer listener");
        }else {
            xValue.setText("Acceleometer Not Supported");
            yValue.setText("Acceleometer Not Supported");
            zValue.setText("Acceleometer Not Supported");
        }

        //Método para parar la escucha del sensor giroscopio
        mGyro = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        if (mGyro != null) {
            sensorManager.registerListener(MainActivity.this, mGyro, SensorManager.SENSOR_DELAY_NORMAL);

            //el log determina un mensaje especifico
            Log.d(TAG, "onCreate: Registered Gyro listener");
        }else {
            xGyroValue.setText("Gyro Not Supported");
            yGyroValue.setText("Gyro Not Supported");
            zGyroValue.setText("Gyro Not Supported");
        }

        //Método para parar la escucha del sensor magnometro
        mMagno = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        if (mMagno != null) {
            sensorManager.registerListener(MainActivity.this, mMagno, SensorManager.SENSOR_DELAY_NORMAL);

            //el log determina un mensaje especifico
            Log.d(TAG, "onCreate: Registered Magnometer listener");
        }else {
            xMagnoValue.setText("Magno Not Supported");
            yMagnoValue.setText("Magno Not Supported");
            zMagnoValue.setText("Magno Not Supported");
        }

        //Método para parar la escucha del sensor light
        mLight = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        if (mLight != null) {
            sensorManager.registerListener(MainActivity.this, mLight, SensorManager.SENSOR_DELAY_NORMAL);

            //el log determina un mensaje especifico
            Log.d(TAG, "onCreate: Registered Light listener");
        }else {
            light.setText("Light Not Supported");

        }

        //Método para parar la escucha del sensor presion
        mPressure = sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE);
        if (mPressure != null) {
            sensorManager.registerListener(MainActivity.this, mPressure, SensorManager.SENSOR_DELAY_NORMAL);

            //el log determina un mensaje especifico
            Log.d(TAG, "onCreate: Registered Pressure listener");
        }else {
            pressure.setText("Pressure Not Supported");

        }

        //Método para parar la escucha del sensor temperatura ambiental
        mTemp = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
        if (mTemp != null) {
            sensorManager.registerListener(MainActivity.this, mTemp, SensorManager.SENSOR_DELAY_NORMAL);

            //el log determina un mensaje especifico
            Log.d(TAG, "onCreate: Registered Tem listener");
        }else {
            temp.setText("Tem Not Supported");

        }

        //Método para parar la escucha del sensor Humedad
        mHumi = sensorManager.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY);
        if (mHumi != null) {
            sensorManager.registerListener(MainActivity.this, mHumi, SensorManager.SENSOR_DELAY_NORMAL);

            //el log determina un mensaje especifico
            Log.d(TAG, "onCreate: Registered Humi listener");
        }else {
            humi.setText("Humi Not Supported");

        }
    }


    //Metodo que escucha el cambio de los sensores
    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        Sensor sensor = sensorEvent.sensor;


        if (sensor.getType()== Sensor.TYPE_ACCELEROMETER){
            Log.d(TAG, "onSensorChanged: X " + sensorEvent.values[0]+ "Y:" + sensorEvent.values[1] + "Z:" + sensorEvent.values[2]
            + sensorEvent);

            xValue.setText("xValue: " + sensorEvent.values[0]);
            yValue.setText("xValue: " + sensorEvent.values[1]);
            zValue.setText("xValue: " + sensorEvent.values[2]);
        }else if (sensor.getType()== Sensor.TYPE_GYROSCOPE){

            xGyroValue.setText("xGValue: " + sensorEvent.values[0]);
            yGyroValue.setText("yGValue: " + sensorEvent.values[1]);
            zGyroValue.setText("zGValue: " + sensorEvent.values[2]);
        }else if (sensor.getType()== Sensor.TYPE_MAGNETIC_FIELD){
            xMagnoValue.setText("xMValue: " + sensorEvent.values[0]);
            yMagnoValue.setText("yMValue: " + sensorEvent.values[1]);
            zMagnoValue.setText("zMValue: " + sensorEvent.values[2]);
        }else if (sensor.getType()== Sensor.TYPE_LIGHT){
            light.setText("Light: " + sensorEvent.values[0]);
        }else if (sensor.getType()== Sensor.TYPE_PRESSURE){
            pressure.setText("Pressure: " + sensorEvent.values[0]);
        }else if (sensor.getType()== Sensor.TYPE_AMBIENT_TEMPERATURE){
            temp.setText("Temp: " + sensorEvent.values[0]);
        }else if (sensor.getType()== Sensor.TYPE_RELATIVE_HUMIDITY){
            humi.setText("Humidity: " + sensorEvent.values[0]);
        }


    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
