package com.d.healthmonitoring.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.d.healthmonitoring.Model.AssignData;
import com.d.healthmonitoring.R;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivityPatient extends AppCompatActivity {

    Button temp,heartbeat,ecg, addmedicine,checkmedicine;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_patient);
        temp=(Button)findViewById(R.id.temp);
        heartbeat=(Button)findViewById(R.id.heart);
        ecg=(Button)findViewById(R.id.ecg);
        addmedicine =(Button)findViewById(R.id.addmedicine);
        checkmedicine =(Button)findViewById(R.id.checkmedicine);
        final AssignData assignData= (AssignData) getIntent().getSerializableExtra("Patient");
        TextView pname= findViewById(R.id.pname);
        TextView Fathername=findViewById(R.id.fname);
        TextView Address= findViewById(R.id.paddress);
        TextView Disease= findViewById(R.id.pdisease);
        TextView Phonenumber= findViewById(R.id.pphone);
        TextView Date= findViewById(R.id.pdate);
        TextView Deviceid= findViewById(R.id.pdeviceid);


        pname.setText(assignData.getPatientData().getPatientname());
        Fathername.setText(assignData.getPatientData().getFathername());
        Address.setText(assignData.getPatientData().getAddress());
        Disease.setText(assignData.getPatientData().getDisease());
        Phonenumber.setText(assignData.getPatientData().getPhonenumber());
        Date.setText(assignData.getPatientData().getCreatedAt());
        Deviceid.setText(assignData.getPatientData().getDeviceid());

        heartbeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(ProfileActivityPatient.this, CheckHeartbeatActivity.class);
                startActivity(intent);
            }
        });
        ecg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 =new Intent(ProfileActivityPatient.this, CheckEcgActivity.class);
                startActivity(intent1);
            }
        });
        temp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 =new Intent(ProfileActivityPatient.this, CheckTemperatureActivity.class);
                startActivity(intent2);
            }
        });
        addmedicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 =new Intent(ProfileActivityPatient.this, AddMedicineActivity.class);
                intent3.putExtra("pid",assignData.getPatientData().getId());
                intent3.putExtra("did",assignData.getDoctorData().getId());
                intent3.putExtra("doctorname",assignData.getDoctorData().getDoctorname());

                intent3.putExtra("token",assignData.getDoctorData().getAccessToken());
                startActivity(intent3);
            }
        });
        checkmedicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 =new Intent(ProfileActivityPatient.this, SeeMedicineActivirty.class);
                intent4.putExtra("id",assignData.getPatientData().getId());
                intent4.putExtra("token",assignData.getDoctorData().getAccessToken());

                startActivity(intent4);

            }
        });
    }
}
