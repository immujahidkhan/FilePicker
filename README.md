# AndroidX FilePicker 
AndroidX File Picker - Android Multiple File Picker Library 

```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

dependencies {
	        implementation 'com.github.immujahidkhan:FilePicker:Tag'
	}
```
#Usage

```
    private final static int FILE_REQUEST_CODE = 198;
    private ArrayList<MediaFile> mediaFiles = new ArrayList<>();
  Intent intent = new Intent(getActivity(), FilePickerActivity.class);
            intent.putExtra(FilePickerActivity.CONFIGS, new Configurations.Builder()
                    .setCheckPermission(true)
                    .setSelectedMediaFiles(mediaFiles)
                    .setShowFiles(true)
                    .setShowImages(true)
                    .setShowAudios(false)
                    .setShowVideos(false)
                    .setIgnoreNoMedia(false)
                    .enableVideoCapture(false)
                    .enableImageCapture(true)
                    .setIgnoreHiddenFile(false)
                    .setMaxSelection(2)
                    .build());
            startActivityForResult(intent, FILE_REQUEST_CODE);
            
             @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == FILE_REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            mediaFiles.clear();
            mediaFiles.addAll(data.getParcelableArrayListExtra(FilePickerActivity.MEDIA_FILES));
            fileListAdapter.notifyDataSetChanged();
            binding.fileList.requestFocus();
        }
    }
```
