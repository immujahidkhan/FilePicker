package com.androidx.filePicker.activity;

import android.content.Context;
import android.content.Intent;

import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.androidx.filePicker.config.Configurations;
import com.androidx.filePicker.model.MediaFile;

import java.util.List;

import static android.app.Activity.RESULT_OK;

public class PickFile extends ActivityResultContract<Configurations, List<MediaFile>> {
    private boolean throughDir = false;

    @NonNull
    @Override
    public Intent createIntent(@NonNull Context context, Configurations input) {
        return new Intent(context,
                throughDir ? DirSelectActivity.class : FilePickerActivity.class
        ).putExtra(FilePickerActivity.CONFIGS, input);
    }

    @Override
    public List<MediaFile> parseResult(int resultCode, @Nullable Intent intent) {
        if (resultCode == RESULT_OK && intent != null) {
            return intent.getParcelableArrayListExtra(FilePickerActivity.MEDIA_FILES);
        }
        return null;
    }

    public PickFile throughDir(boolean throughDir) {
        this.throughDir = throughDir;
        return this;
    }
}