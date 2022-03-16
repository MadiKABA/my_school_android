package com.example.my_school;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SignUpActivity extends AppCompatActivity {


    private EditText txtLoginDb,txtPasswordDb;
    private Button btnAdd,btnUpdate,btnDelete,btnList;
    private String login,password;
    private DbUser db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        txtLoginDb=findViewById(R.id.txtLoginDb);
        txtPasswordDb=findViewById(R.id.txtPasswordDb);
        btnAdd=findViewById(R.id.btnAdd);
        btnUpdate=findViewById(R.id.btnUpdate);
        btnDelete=findViewById(R.id.btnDelete);
        btnList=findViewById(R.id.btnList);

        db=new DbUser(this);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login=txtLoginDb.getText().toString().trim();
                password=txtPasswordDb.getText().toString().trim();

                boolean b=db.add(login,password);

                if (b)
                {
                    Toast.makeText(SignUpActivity.this, getString(R.string.success_create), Toast.LENGTH_SHORT).show();
                }else 
                {
                    Toast.makeText(SignUpActivity.this, getString(R.string.error_create), Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login=txtLoginDb.getText().toString().trim();
                password=txtPasswordDb.getText().toString().trim();

                boolean b=db.upadte(login,password);

                if (b)
                {
                    Toast.makeText(SignUpActivity.this, getString(R.string.success_update), Toast.LENGTH_SHORT).show();
                }else
                {
                    Toast.makeText(SignUpActivity.this, getString(R.string.error_update), Toast.LENGTH_SHORT).show();
                }
            }
        });


        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login=txtLoginDb.getText().toString().trim();
                password=txtPasswordDb.getText().toString().trim();

                boolean b=db.delete(login);

                if (b)
                {
                    Toast.makeText(SignUpActivity.this, getString(R.string.success_delete), Toast.LENGTH_SHORT).show();
                }else
                {
                    Toast.makeText(SignUpActivity.this, getString(R.string.error_delete), Toast.LENGTH_SHORT).show();
                }
            }
        });


        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<String> list=db.getUsers();

                String result="";
                for (int i = 0; i < list.size(); i++) {
                    result+=list.get(i)+"\n\n";
                }
                Toast.makeText(SignUpActivity.this,result, Toast.LENGTH_SHORT).show();
            }
        });
    }
}