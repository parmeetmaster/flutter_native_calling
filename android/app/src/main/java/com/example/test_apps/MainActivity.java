package com.example.test_apps;

import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;

import io.flutter.embedding.android.FlutterActivity;
import io.flutter.embedding.engine.*;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public class MainActivity extends FlutterActivity {
    String METHOD_CHANNEL = "com.example.test_apps/toast";

    @Override
    public void configureFlutterEngine(@NonNull FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        new MethodChannel(flutterEngine.getDartExecutor().getBinaryMessenger(), METHOD_CHANNEL)
                .setMethodCallHandler(
                        (call, result) -> {
                            // Note: this method is invoked on the main thread.
                            // TODO

                            if (call.method.equals("show_toast")) {
                                String text = call.argument("message");
                                text += "kya hua";
                                result.success(text);

                            }else  if (call.method.equals("move_activity")) {
                              Intent i=new Intent(MainActivity.this,MainActivity3.class);
                              startActivity(i);

                            }


                        }
                );
    }
}

