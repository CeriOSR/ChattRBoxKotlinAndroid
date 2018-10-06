package com.ceriosrey.chattrbox;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 10}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0003\u0017\u0018\u0019B-\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u001c\u0010\u000f\u001a\u00020\u00102\n\u0010\u0011\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\u001c\u0010\u0013\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000eH\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/ceriosrey/chattrbox/PeopleAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/ceriosrey/chattrbox/PeopleAdapter$PeopleViewHolder;", "itemList", "", "Lcom/ceriosrey/chattrbox/ChattRBoxItems;", "listenerPlayAudio", "Lcom/ceriosrey/chattrbox/PeopleAdapter$OnCellClickListener;", "editMode", "", "listenerDelete", "Lcom/ceriosrey/chattrbox/PeopleAdapter$OnDeleteButtonClickListener;", "(Ljava/util/List;Lcom/ceriosrey/chattrbox/PeopleAdapter$OnCellClickListener;ZLcom/ceriosrey/chattrbox/PeopleAdapter$OnDeleteButtonClickListener;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "OnCellClickListener", "OnDeleteButtonClickListener", "PeopleViewHolder", "app_debug"})
public final class PeopleAdapter extends android.support.v7.widget.RecyclerView.Adapter<com.ceriosrey.chattrbox.PeopleAdapter.PeopleViewHolder> {
    private final java.util.List<com.ceriosrey.chattrbox.ChattRBoxItems> itemList = null;
    private final com.ceriosrey.chattrbox.PeopleAdapter.OnCellClickListener listenerPlayAudio = null;
    private final boolean editMode = false;
    private final com.ceriosrey.chattrbox.PeopleAdapter.OnDeleteButtonClickListener listenerDelete = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.ceriosrey.chattrbox.PeopleAdapter.PeopleViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.ceriosrey.chattrbox.PeopleAdapter.PeopleViewHolder holder, int position) {
    }
    
    public PeopleAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<com.ceriosrey.chattrbox.ChattRBoxItems> itemList, @org.jetbrains.annotations.NotNull()
    com.ceriosrey.chattrbox.PeopleAdapter.OnCellClickListener listenerPlayAudio, boolean editMode, @org.jetbrains.annotations.NotNull()
    com.ceriosrey.chattrbox.PeopleAdapter.OnDeleteButtonClickListener listenerDelete) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 10}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/ceriosrey/chattrbox/PeopleAdapter$OnCellClickListener;", "", "onCellClick", "", "chattRItem", "Lcom/ceriosrey/chattrbox/ChattRBoxItems;", "position", "", "app_debug"})
    public static abstract interface OnCellClickListener {
        
        public abstract void onCellClick(@org.jetbrains.annotations.NotNull()
        com.ceriosrey.chattrbox.ChattRBoxItems chattRItem, int position);
    }
    
    @kotlin.Metadata(mv = {1, 1, 10}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/ceriosrey/chattrbox/PeopleAdapter$OnDeleteButtonClickListener;", "", "onDeleteButtonClick", "", "chattRItem", "Lcom/ceriosrey/chattrbox/ChattRBoxItems;", "position", "", "app_debug"})
    public static abstract interface OnDeleteButtonClickListener {
        
        public abstract void onDeleteButtonClick(@org.jetbrains.annotations.NotNull()
        com.ceriosrey.chattrbox.ChattRBoxItems chattRItem, int position);
    }
    
    @kotlin.Metadata(mv = {1, 1, 10}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/ceriosrey/chattrbox/PeopleAdapter$PeopleViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/ceriosrey/chattrbox/PeopleAdapter;Landroid/view/View;)V", "bind", "", "chattRItem", "Lcom/ceriosrey/chattrbox/ChattRBoxItems;", "position", "", "bindEditOption", "app_debug"})
    public final class PeopleViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder {
        private final android.view.View view = null;
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.ceriosrey.chattrbox.ChattRBoxItems chattRItem, int position) {
        }
        
        public final void bindEditOption(@org.jetbrains.annotations.NotNull()
        com.ceriosrey.chattrbox.ChattRBoxItems chattRItem, int position) {
        }
        
        public PeopleViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View view) {
            super(null);
        }
    }
}