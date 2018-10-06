package com.ceriosrey.chattrbox;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 10}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006B\u0005\u00a2\u0006\u0002\u0010\u0007J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0012H\u0002J\u0010\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\b\u001a\u00020\tH\u0002J\u0018\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0012\u0010!\u001a\u00020\u001b2\b\u0010\"\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010#\u001a\u00020\u001b2\b\u0010$\u001a\u0004\u0018\u00010%H\u0014J\u0012\u0010&\u001a\u00020\r2\b\u0010\'\u001a\u0004\u0018\u00010(H\u0016J\u0018\u0010)\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020 H\u0016J\b\u0010*\u001a\u00020\u001bH\u0014J\"\u0010+\u001a\u00020\r2\b\u0010\"\u001a\u0004\u0018\u00010\u00142\u0006\u0010,\u001a\u00020 2\u0006\u0010-\u001a\u00020 H\u0016J\u0010\u0010.\u001a\u00020\u001b2\u0006\u0010/\u001a\u00020 H\u0016J\u0012\u00100\u001a\u00020\r2\b\u00101\u001a\u0004\u0018\u000102H\u0016J\b\u00103\u001a\u000204H\u0002J\u0010\u00105\u001a\u00020\u001b2\u0006\u00106\u001a\u00020\tH\u0002J\u0010\u00107\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0012H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082D\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00068"}, d2 = {"Lcom/ceriosrey/chattrbox/PeopleActivity;", "Landroid/support/v7/app/AppCompatActivity;", "Landroid/speech/tts/TextToSpeech$OnInitListener;", "Landroid/media/MediaPlayer$OnCompletionListener;", "Landroid/media/MediaPlayer$OnErrorListener;", "Lcom/ceriosrey/chattrbox/PeopleAdapter$OnCellClickListener;", "Lcom/ceriosrey/chattrbox/PeopleAdapter$OnDeleteButtonClickListener;", "()V", "category", "", "displayMetrics", "Landroid/util/DisplayMetrics;", "editMode", "", "internalStorageProvider", "Lcom/ceriosrey/chattrbox/InternalStorageProvider;", "itemList", "", "Lcom/ceriosrey/chattrbox/ChattRBoxItems;", "player", "Landroid/media/MediaPlayer;", "result", "Lio/realm/RealmResults;", "Lcom/ceriosrey/chattrbox/ChattRItem;", "tts", "Landroid/speech/tts/TextToSpeech;", "deleteFromRealm", "", "chattRItem", "loadFromRealm", "onCellClick", "position", "", "onCompletion", "mp", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "onDeleteButtonClick", "onDestroy", "onError", "what", "extra", "onInit", "status", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "phoneOrTablet", "", "playAudio", "audioFileName", "textToSpeech", "app_debug"})
public final class PeopleActivity extends android.support.v7.app.AppCompatActivity implements android.speech.tts.TextToSpeech.OnInitListener, android.media.MediaPlayer.OnCompletionListener, android.media.MediaPlayer.OnErrorListener, com.ceriosrey.chattrbox.PeopleAdapter.OnCellClickListener, com.ceriosrey.chattrbox.PeopleAdapter.OnDeleteButtonClickListener {
    private android.media.MediaPlayer player;
    private java.util.List<com.ceriosrey.chattrbox.ChattRBoxItems> itemList;
    private io.realm.RealmResults<com.ceriosrey.chattrbox.ChattRItem> result;
    private final java.lang.String category = "People";
    private boolean editMode;
    private com.ceriosrey.chattrbox.InternalStorageProvider internalStorageProvider;
    private android.speech.tts.TextToSpeech tts;
    private android.util.DisplayMetrics displayMetrics;
    private java.util.HashMap _$_findViewCache;
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public boolean onCreateOptionsMenu(@org.jetbrains.annotations.Nullable()
    android.view.Menu menu) {
        return false;
    }
    
    @java.lang.Override()
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.Nullable()
    android.view.MenuItem item) {
        return false;
    }
    
    @java.lang.Override()
    public void onInit(int status) {
    }
    
    @java.lang.Override()
    public void onCompletion(@org.jetbrains.annotations.Nullable()
    android.media.MediaPlayer mp) {
    }
    
    @java.lang.Override()
    public boolean onError(@org.jetbrains.annotations.Nullable()
    android.media.MediaPlayer mp, int what, int extra) {
        return false;
    }
    
    @java.lang.Override()
    public void onCellClick(@org.jetbrains.annotations.NotNull()
    com.ceriosrey.chattrbox.ChattRBoxItems chattRItem, int position) {
    }
    
    @java.lang.Override()
    public void onDeleteButtonClick(@org.jetbrains.annotations.NotNull()
    com.ceriosrey.chattrbox.ChattRBoxItems chattRItem, int position) {
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    private final double phoneOrTablet() {
        return 0.0;
    }
    
    private final void textToSpeech(com.ceriosrey.chattrbox.ChattRBoxItems chattRItem) {
    }
    
    private final void playAudio(java.lang.String audioFileName) {
    }
    
    private final void deleteFromRealm(com.ceriosrey.chattrbox.ChattRBoxItems chattRItem) {
    }
    
    private final void loadFromRealm(java.lang.String category) {
    }
    
    public PeopleActivity() {
        super();
    }
}