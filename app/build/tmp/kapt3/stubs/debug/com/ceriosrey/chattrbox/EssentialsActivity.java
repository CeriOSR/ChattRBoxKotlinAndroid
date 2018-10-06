package com.ceriosrey.chattrbox;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 10}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0005\u00a2\u0006\u0002\u0010\u0005J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0010H\u0002J\u0010\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\b\u0010\u001c\u001a\u00020\u0019H\u0016J\u0010\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0010H\u0016J\u0012\u0010\u001e\u001a\u00020\u00192\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0014J\u0012\u0010!\u001a\u00020\u000b2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0018\u0010$\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00102\u0006\u0010%\u001a\u00020&H\u0016J\b\u0010\'\u001a\u00020\u0019H\u0014J\u0010\u0010(\u001a\u00020\u00192\u0006\u0010)\u001a\u00020&H\u0016J\u0012\u0010*\u001a\u00020\u000b2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\b\u0010-\u001a\u00020.H\u0002J\b\u0010/\u001a\u00020\u0019H\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00060"}, d2 = {"Lcom/ceriosrey/chattrbox/EssentialsActivity;", "Landroid/support/v7/app/AppCompatActivity;", "Landroid/speech/tts/TextToSpeech$OnInitListener;", "Lcom/ceriosrey/chattrbox/EssentialsAdapter$onCellItemClickListener;", "Lcom/ceriosrey/chattrbox/EssentialsAdapter$onDeleteButtonClickListener;", "()V", "category", "", "displayMetrics", "Landroid/util/DisplayMetrics;", "editMode", "", "internalStorageProvider", "Lcom/ceriosrey/chattrbox/InternalStorageProvider;", "itemList", "", "Lcom/ceriosrey/chattrbox/ChattRBoxItems;", "readButton", "Landroid/widget/Button;", "result", "Lio/realm/RealmResults;", "Lcom/ceriosrey/chattrbox/ChattRItem;", "tts", "Landroid/speech/tts/TextToSpeech;", "deleteFromRealm", "", "chattRItem", "loadFromRealm", "onBackPressed", "onCellClick", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "onDeleteClick", "position", "", "onDestroy", "onInit", "status", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "phoneOrTablet", "", "textToSpeech", "app_debug"})
public final class EssentialsActivity extends android.support.v7.app.AppCompatActivity implements android.speech.tts.TextToSpeech.OnInitListener, com.ceriosrey.chattrbox.EssentialsAdapter.onCellItemClickListener, com.ceriosrey.chattrbox.EssentialsAdapter.onDeleteButtonClickListener {
    private java.lang.String category;
    private io.realm.RealmResults<com.ceriosrey.chattrbox.ChattRItem> result;
    private java.util.List<com.ceriosrey.chattrbox.ChattRBoxItems> itemList;
    private android.speech.tts.TextToSpeech tts;
    private android.widget.Button readButton;
    private boolean editMode;
    private android.util.DisplayMetrics displayMetrics;
    private com.ceriosrey.chattrbox.InternalStorageProvider internalStorageProvider;
    private java.util.HashMap _$_findViewCache;
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onInit(int status) {
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
    protected void onDestroy() {
    }
    
    @java.lang.Override()
    public void onBackPressed() {
    }
    
    @java.lang.Override()
    public void onCellClick(@org.jetbrains.annotations.NotNull()
    com.ceriosrey.chattrbox.ChattRBoxItems chattRItem) {
    }
    
    @java.lang.Override()
    public void onDeleteClick(@org.jetbrains.annotations.NotNull()
    com.ceriosrey.chattrbox.ChattRBoxItems chattRItem, int position) {
    }
    
    private final double phoneOrTablet() {
        return 0.0;
    }
    
    private final void deleteFromRealm(com.ceriosrey.chattrbox.ChattRBoxItems chattRItem) {
    }
    
    private final void loadFromRealm(java.lang.String category) {
    }
    
    private final void textToSpeech() {
    }
    
    public EssentialsActivity() {
        super();
    }
}