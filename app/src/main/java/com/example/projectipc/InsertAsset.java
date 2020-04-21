package com.example.projectipc;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InsertAsset extends AppCompatActivity {

    EditText deskripsi;

    Button save;
    APIService interfaceAPI;
    Date CurrentTime;
    RadioGroup status;
    RadioButton standby;
    RadioButton statoperate;
    RadioButton breakdown;
    String ResultStatus;
    ;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inspection);
        status =(RadioGroup) findViewById(R.id.Status);
        standby =(RadioButton)findViewById(R.id.standby);
        breakdown =(RadioButton)findViewById(R.id.breakdown);
        statoperate =(RadioButton)findViewById(R.id.operate);
        save = (Button) findViewById(R.id.InputChecklist);
        Date newDate  = new Date(System.currentTimeMillis());

        String date= newDate.toString();

        interfaceAPI=RequestAPI.getAPI().create(APIService.class);
        save= (Button)findViewById(R.id.InputChecklist);
        save.setOnClickListener(new View.OnClickListener() {

            public  String Status(){
            int Selected = status.getCheckedRadioButtonId();
            if(Selected== standby.getId()){
               return ResultStatus=standby.getText().toString();
            }if(Selected == statoperate.getId()){
                return ResultStatus=statoperate.getText().toString();
            }if(Selected == breakdown.getId()){
                return ResultStatus=breakdown.getText().toString();
            }return ResultStatus;
        }
            @Override
            public void onClick(View v) {
                Call<InspectionMachine> assetCall = interfaceAPI.InsertMesin(date,Status(),Status());

            assetCall.enqueue(new Callback<InspectionMachine>() {
                @Override
                public void onResponse(Call<InspectionMachine> call, Response<InspectionMachine> response) {
response.message();
                 if(response.code()==400){
                        Toast.makeText(InsertAsset.this,"400",Toast.LENGTH_SHORT).show();

                    }if(response.code()==500){
                        Toast.makeText(InsertAsset.this,"500",Toast.LENGTH_SHORT).show();

                    }if(response.code()==404){
                        Toast.makeText(InsertAsset.this,"404",Toast.LENGTH_SHORT).show();


                    }if(response.code()==401){
                        Toast.makeText(InsertAsset.this,"401",Toast.LENGTH_SHORT).show();

                    }if(response.code()==200) {
                        Toast.makeText(InsertAsset.this, response.message(), Toast.LENGTH_SHORT).show();

                    }


                }


                public void onFailure(Call<InspectionMachine> call, Throwable t) {

                    t.getMessage();
                    Toast.makeText(InsertAsset.this,t.getMessage(),Toast.LENGTH_SHORT).show();
                    t.printStackTrace();
                    t.printStackTrace();
                    t.getLocalizedMessage();


                }
            });
            }
        });










    }

}
