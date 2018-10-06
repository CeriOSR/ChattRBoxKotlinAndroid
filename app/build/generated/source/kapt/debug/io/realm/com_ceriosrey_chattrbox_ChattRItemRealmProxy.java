package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.ProxyUtils;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsList;
import io.realm.internal.OsObject;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.Property;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.Table;
import io.realm.internal.android.JsonUtils;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("all")
public class com_ceriosrey_chattrbox_ChattRItemRealmProxy extends com.ceriosrey.chattrbox.ChattRItem
    implements RealmObjectProxy, com_ceriosrey_chattrbox_ChattRItemRealmProxyInterface {

    static final class ChattRItemColumnInfo extends ColumnInfo {
        long itemIdIndex;
        long itemNameIndex;
        long itemCategoryIndex;
        long itemImageFileNameIndex;
        long itemAudioFileNameIndex;

        ChattRItemColumnInfo(OsSchemaInfo schemaInfo) {
            super(5);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("ChattRItem");
            this.itemIdIndex = addColumnDetails("itemId", "itemId", objectSchemaInfo);
            this.itemNameIndex = addColumnDetails("itemName", "itemName", objectSchemaInfo);
            this.itemCategoryIndex = addColumnDetails("itemCategory", "itemCategory", objectSchemaInfo);
            this.itemImageFileNameIndex = addColumnDetails("itemImageFileName", "itemImageFileName", objectSchemaInfo);
            this.itemAudioFileNameIndex = addColumnDetails("itemAudioFileName", "itemAudioFileName", objectSchemaInfo);
        }

        ChattRItemColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new ChattRItemColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final ChattRItemColumnInfo src = (ChattRItemColumnInfo) rawSrc;
            final ChattRItemColumnInfo dst = (ChattRItemColumnInfo) rawDst;
            dst.itemIdIndex = src.itemIdIndex;
            dst.itemNameIndex = src.itemNameIndex;
            dst.itemCategoryIndex = src.itemCategoryIndex;
            dst.itemImageFileNameIndex = src.itemImageFileNameIndex;
            dst.itemAudioFileNameIndex = src.itemAudioFileNameIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private ChattRItemColumnInfo columnInfo;
    private ProxyState<com.ceriosrey.chattrbox.ChattRItem> proxyState;

    com_ceriosrey_chattrbox_ChattRItemRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (ChattRItemColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.ceriosrey.chattrbox.ChattRItem>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$itemId() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.itemIdIndex);
    }

    @Override
    public void realmSet$itemId(String value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'itemId' cannot be changed after object was created.");
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$itemName() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.itemNameIndex);
    }

    @Override
    public void realmSet$itemName(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'itemName' to null.");
            }
            row.getTable().setString(columnInfo.itemNameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field 'itemName' to null.");
        }
        proxyState.getRow$realm().setString(columnInfo.itemNameIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$itemCategory() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.itemCategoryIndex);
    }

    @Override
    public void realmSet$itemCategory(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'itemCategory' to null.");
            }
            row.getTable().setString(columnInfo.itemCategoryIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field 'itemCategory' to null.");
        }
        proxyState.getRow$realm().setString(columnInfo.itemCategoryIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$itemImageFileName() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.itemImageFileNameIndex);
    }

    @Override
    public void realmSet$itemImageFileName(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'itemImageFileName' to null.");
            }
            row.getTable().setString(columnInfo.itemImageFileNameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field 'itemImageFileName' to null.");
        }
        proxyState.getRow$realm().setString(columnInfo.itemImageFileNameIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$itemAudioFileName() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.itemAudioFileNameIndex);
    }

    @Override
    public void realmSet$itemAudioFileName(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'itemAudioFileName' to null.");
            }
            row.getTable().setString(columnInfo.itemAudioFileNameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field 'itemAudioFileName' to null.");
        }
        proxyState.getRow$realm().setString(columnInfo.itemAudioFileNameIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("ChattRItem", 5, 0);
        builder.addPersistedProperty("itemId", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("itemName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("itemCategory", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("itemImageFileName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("itemAudioFileName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static ChattRItemColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new ChattRItemColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "ChattRItem";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "ChattRItem";
    }

    @SuppressWarnings("cast")
    public static com.ceriosrey.chattrbox.ChattRItem createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.ceriosrey.chattrbox.ChattRItem obj = null;
        if (update) {
            Table table = realm.getTable(com.ceriosrey.chattrbox.ChattRItem.class);
            ChattRItemColumnInfo columnInfo = (ChattRItemColumnInfo) realm.getSchema().getColumnInfo(com.ceriosrey.chattrbox.ChattRItem.class);
            long pkColumnIndex = columnInfo.itemIdIndex;
            long rowIndex = Table.NO_MATCH;
            if (!json.isNull("itemId")) {
                rowIndex = table.findFirstString(pkColumnIndex, json.getString("itemId"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.ceriosrey.chattrbox.ChattRItem.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_ceriosrey_chattrbox_ChattRItemRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("itemId")) {
                if (json.isNull("itemId")) {
                    obj = (io.realm.com_ceriosrey_chattrbox_ChattRItemRealmProxy) realm.createObjectInternal(com.ceriosrey.chattrbox.ChattRItem.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_ceriosrey_chattrbox_ChattRItemRealmProxy) realm.createObjectInternal(com.ceriosrey.chattrbox.ChattRItem.class, json.getString("itemId"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'itemId'.");
            }
        }

        final com_ceriosrey_chattrbox_ChattRItemRealmProxyInterface objProxy = (com_ceriosrey_chattrbox_ChattRItemRealmProxyInterface) obj;
        if (json.has("itemName")) {
            if (json.isNull("itemName")) {
                objProxy.realmSet$itemName(null);
            } else {
                objProxy.realmSet$itemName((String) json.getString("itemName"));
            }
        }
        if (json.has("itemCategory")) {
            if (json.isNull("itemCategory")) {
                objProxy.realmSet$itemCategory(null);
            } else {
                objProxy.realmSet$itemCategory((String) json.getString("itemCategory"));
            }
        }
        if (json.has("itemImageFileName")) {
            if (json.isNull("itemImageFileName")) {
                objProxy.realmSet$itemImageFileName(null);
            } else {
                objProxy.realmSet$itemImageFileName((String) json.getString("itemImageFileName"));
            }
        }
        if (json.has("itemAudioFileName")) {
            if (json.isNull("itemAudioFileName")) {
                objProxy.realmSet$itemAudioFileName(null);
            } else {
                objProxy.realmSet$itemAudioFileName((String) json.getString("itemAudioFileName"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.ceriosrey.chattrbox.ChattRItem createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.ceriosrey.chattrbox.ChattRItem obj = new com.ceriosrey.chattrbox.ChattRItem();
        final com_ceriosrey_chattrbox_ChattRItemRealmProxyInterface objProxy = (com_ceriosrey_chattrbox_ChattRItemRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("itemId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$itemId((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$itemId(null);
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("itemName")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$itemName((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$itemName(null);
                }
            } else if (name.equals("itemCategory")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$itemCategory((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$itemCategory(null);
                }
            } else if (name.equals("itemImageFileName")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$itemImageFileName((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$itemImageFileName(null);
                }
            } else if (name.equals("itemAudioFileName")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$itemAudioFileName((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$itemAudioFileName(null);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'itemId'.");
        }
        return realm.copyToRealm(obj);
    }

    public static com.ceriosrey.chattrbox.ChattRItem copyOrUpdate(Realm realm, com.ceriosrey.chattrbox.ChattRItem object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null) {
            final BaseRealm otherRealm = ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm();
            if (otherRealm.threadId != realm.threadId) {
                throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
            }
            if (otherRealm.getPath().equals(realm.getPath())) {
                return object;
            }
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.ceriosrey.chattrbox.ChattRItem) cachedRealmObject;
        }

        com.ceriosrey.chattrbox.ChattRItem realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.ceriosrey.chattrbox.ChattRItem.class);
            ChattRItemColumnInfo columnInfo = (ChattRItemColumnInfo) realm.getSchema().getColumnInfo(com.ceriosrey.chattrbox.ChattRItem.class);
            long pkColumnIndex = columnInfo.itemIdIndex;
            long rowIndex = table.findFirstString(pkColumnIndex, ((com_ceriosrey_chattrbox_ChattRItemRealmProxyInterface) object).realmGet$itemId());
            if (rowIndex == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.ceriosrey.chattrbox.ChattRItem.class), false, Collections.<String> emptyList());
                    realmObject = new io.realm.com_ceriosrey_chattrbox_ChattRItemRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, realmObject, object, cache) : copy(realm, object, update, cache);
    }

    public static com.ceriosrey.chattrbox.ChattRItem copy(Realm realm, com.ceriosrey.chattrbox.ChattRItem newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.ceriosrey.chattrbox.ChattRItem) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        com.ceriosrey.chattrbox.ChattRItem realmObject = realm.createObjectInternal(com.ceriosrey.chattrbox.ChattRItem.class, ((com_ceriosrey_chattrbox_ChattRItemRealmProxyInterface) newObject).realmGet$itemId(), false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        com_ceriosrey_chattrbox_ChattRItemRealmProxyInterface realmObjectSource = (com_ceriosrey_chattrbox_ChattRItemRealmProxyInterface) newObject;
        com_ceriosrey_chattrbox_ChattRItemRealmProxyInterface realmObjectCopy = (com_ceriosrey_chattrbox_ChattRItemRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$itemName(realmObjectSource.realmGet$itemName());
        realmObjectCopy.realmSet$itemCategory(realmObjectSource.realmGet$itemCategory());
        realmObjectCopy.realmSet$itemImageFileName(realmObjectSource.realmGet$itemImageFileName());
        realmObjectCopy.realmSet$itemAudioFileName(realmObjectSource.realmGet$itemAudioFileName());
        return realmObject;
    }

    public static long insert(Realm realm, com.ceriosrey.chattrbox.ChattRItem object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.ceriosrey.chattrbox.ChattRItem.class);
        long tableNativePtr = table.getNativePtr();
        ChattRItemColumnInfo columnInfo = (ChattRItemColumnInfo) realm.getSchema().getColumnInfo(com.ceriosrey.chattrbox.ChattRItem.class);
        long pkColumnIndex = columnInfo.itemIdIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((com_ceriosrey_chattrbox_ChattRItemRealmProxyInterface) object).realmGet$itemId();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, (String)primaryKeyValue);
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, primaryKeyValue);
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$itemName = ((com_ceriosrey_chattrbox_ChattRItemRealmProxyInterface) object).realmGet$itemName();
        if (realmGet$itemName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.itemNameIndex, rowIndex, realmGet$itemName, false);
        }
        String realmGet$itemCategory = ((com_ceriosrey_chattrbox_ChattRItemRealmProxyInterface) object).realmGet$itemCategory();
        if (realmGet$itemCategory != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.itemCategoryIndex, rowIndex, realmGet$itemCategory, false);
        }
        String realmGet$itemImageFileName = ((com_ceriosrey_chattrbox_ChattRItemRealmProxyInterface) object).realmGet$itemImageFileName();
        if (realmGet$itemImageFileName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.itemImageFileNameIndex, rowIndex, realmGet$itemImageFileName, false);
        }
        String realmGet$itemAudioFileName = ((com_ceriosrey_chattrbox_ChattRItemRealmProxyInterface) object).realmGet$itemAudioFileName();
        if (realmGet$itemAudioFileName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.itemAudioFileNameIndex, rowIndex, realmGet$itemAudioFileName, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.ceriosrey.chattrbox.ChattRItem.class);
        long tableNativePtr = table.getNativePtr();
        ChattRItemColumnInfo columnInfo = (ChattRItemColumnInfo) realm.getSchema().getColumnInfo(com.ceriosrey.chattrbox.ChattRItem.class);
        long pkColumnIndex = columnInfo.itemIdIndex;
        com.ceriosrey.chattrbox.ChattRItem object = null;
        while (objects.hasNext()) {
            object = (com.ceriosrey.chattrbox.ChattRItem) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((com_ceriosrey_chattrbox_ChattRItemRealmProxyInterface) object).realmGet$itemId();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, (String)primaryKeyValue);
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, primaryKeyValue);
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, rowIndex);
            String realmGet$itemName = ((com_ceriosrey_chattrbox_ChattRItemRealmProxyInterface) object).realmGet$itemName();
            if (realmGet$itemName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.itemNameIndex, rowIndex, realmGet$itemName, false);
            }
            String realmGet$itemCategory = ((com_ceriosrey_chattrbox_ChattRItemRealmProxyInterface) object).realmGet$itemCategory();
            if (realmGet$itemCategory != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.itemCategoryIndex, rowIndex, realmGet$itemCategory, false);
            }
            String realmGet$itemImageFileName = ((com_ceriosrey_chattrbox_ChattRItemRealmProxyInterface) object).realmGet$itemImageFileName();
            if (realmGet$itemImageFileName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.itemImageFileNameIndex, rowIndex, realmGet$itemImageFileName, false);
            }
            String realmGet$itemAudioFileName = ((com_ceriosrey_chattrbox_ChattRItemRealmProxyInterface) object).realmGet$itemAudioFileName();
            if (realmGet$itemAudioFileName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.itemAudioFileNameIndex, rowIndex, realmGet$itemAudioFileName, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.ceriosrey.chattrbox.ChattRItem object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.ceriosrey.chattrbox.ChattRItem.class);
        long tableNativePtr = table.getNativePtr();
        ChattRItemColumnInfo columnInfo = (ChattRItemColumnInfo) realm.getSchema().getColumnInfo(com.ceriosrey.chattrbox.ChattRItem.class);
        long pkColumnIndex = columnInfo.itemIdIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((com_ceriosrey_chattrbox_ChattRItemRealmProxyInterface) object).realmGet$itemId();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, (String)primaryKeyValue);
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$itemName = ((com_ceriosrey_chattrbox_ChattRItemRealmProxyInterface) object).realmGet$itemName();
        if (realmGet$itemName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.itemNameIndex, rowIndex, realmGet$itemName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.itemNameIndex, rowIndex, false);
        }
        String realmGet$itemCategory = ((com_ceriosrey_chattrbox_ChattRItemRealmProxyInterface) object).realmGet$itemCategory();
        if (realmGet$itemCategory != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.itemCategoryIndex, rowIndex, realmGet$itemCategory, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.itemCategoryIndex, rowIndex, false);
        }
        String realmGet$itemImageFileName = ((com_ceriosrey_chattrbox_ChattRItemRealmProxyInterface) object).realmGet$itemImageFileName();
        if (realmGet$itemImageFileName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.itemImageFileNameIndex, rowIndex, realmGet$itemImageFileName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.itemImageFileNameIndex, rowIndex, false);
        }
        String realmGet$itemAudioFileName = ((com_ceriosrey_chattrbox_ChattRItemRealmProxyInterface) object).realmGet$itemAudioFileName();
        if (realmGet$itemAudioFileName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.itemAudioFileNameIndex, rowIndex, realmGet$itemAudioFileName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.itemAudioFileNameIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.ceriosrey.chattrbox.ChattRItem.class);
        long tableNativePtr = table.getNativePtr();
        ChattRItemColumnInfo columnInfo = (ChattRItemColumnInfo) realm.getSchema().getColumnInfo(com.ceriosrey.chattrbox.ChattRItem.class);
        long pkColumnIndex = columnInfo.itemIdIndex;
        com.ceriosrey.chattrbox.ChattRItem object = null;
        while (objects.hasNext()) {
            object = (com.ceriosrey.chattrbox.ChattRItem) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((com_ceriosrey_chattrbox_ChattRItemRealmProxyInterface) object).realmGet$itemId();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, (String)primaryKeyValue);
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, primaryKeyValue);
            }
            cache.put(object, rowIndex);
            String realmGet$itemName = ((com_ceriosrey_chattrbox_ChattRItemRealmProxyInterface) object).realmGet$itemName();
            if (realmGet$itemName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.itemNameIndex, rowIndex, realmGet$itemName, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.itemNameIndex, rowIndex, false);
            }
            String realmGet$itemCategory = ((com_ceriosrey_chattrbox_ChattRItemRealmProxyInterface) object).realmGet$itemCategory();
            if (realmGet$itemCategory != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.itemCategoryIndex, rowIndex, realmGet$itemCategory, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.itemCategoryIndex, rowIndex, false);
            }
            String realmGet$itemImageFileName = ((com_ceriosrey_chattrbox_ChattRItemRealmProxyInterface) object).realmGet$itemImageFileName();
            if (realmGet$itemImageFileName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.itemImageFileNameIndex, rowIndex, realmGet$itemImageFileName, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.itemImageFileNameIndex, rowIndex, false);
            }
            String realmGet$itemAudioFileName = ((com_ceriosrey_chattrbox_ChattRItemRealmProxyInterface) object).realmGet$itemAudioFileName();
            if (realmGet$itemAudioFileName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.itemAudioFileNameIndex, rowIndex, realmGet$itemAudioFileName, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.itemAudioFileNameIndex, rowIndex, false);
            }
        }
    }

    public static com.ceriosrey.chattrbox.ChattRItem createDetachedCopy(com.ceriosrey.chattrbox.ChattRItem realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.ceriosrey.chattrbox.ChattRItem unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.ceriosrey.chattrbox.ChattRItem();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.ceriosrey.chattrbox.ChattRItem) cachedObject.object;
            }
            unmanagedObject = (com.ceriosrey.chattrbox.ChattRItem) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_ceriosrey_chattrbox_ChattRItemRealmProxyInterface unmanagedCopy = (com_ceriosrey_chattrbox_ChattRItemRealmProxyInterface) unmanagedObject;
        com_ceriosrey_chattrbox_ChattRItemRealmProxyInterface realmSource = (com_ceriosrey_chattrbox_ChattRItemRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$itemId(realmSource.realmGet$itemId());
        unmanagedCopy.realmSet$itemName(realmSource.realmGet$itemName());
        unmanagedCopy.realmSet$itemCategory(realmSource.realmGet$itemCategory());
        unmanagedCopy.realmSet$itemImageFileName(realmSource.realmGet$itemImageFileName());
        unmanagedCopy.realmSet$itemAudioFileName(realmSource.realmGet$itemAudioFileName());

        return unmanagedObject;
    }

    static com.ceriosrey.chattrbox.ChattRItem update(Realm realm, com.ceriosrey.chattrbox.ChattRItem realmObject, com.ceriosrey.chattrbox.ChattRItem newObject, Map<RealmModel, RealmObjectProxy> cache) {
        com_ceriosrey_chattrbox_ChattRItemRealmProxyInterface realmObjectTarget = (com_ceriosrey_chattrbox_ChattRItemRealmProxyInterface) realmObject;
        com_ceriosrey_chattrbox_ChattRItemRealmProxyInterface realmObjectSource = (com_ceriosrey_chattrbox_ChattRItemRealmProxyInterface) newObject;
        realmObjectTarget.realmSet$itemName(realmObjectSource.realmGet$itemName());
        realmObjectTarget.realmSet$itemCategory(realmObjectSource.realmGet$itemCategory());
        realmObjectTarget.realmSet$itemImageFileName(realmObjectSource.realmGet$itemImageFileName());
        realmObjectTarget.realmSet$itemAudioFileName(realmObjectSource.realmGet$itemAudioFileName());
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("ChattRItem = proxy[");
        stringBuilder.append("{itemId:");
        stringBuilder.append(realmGet$itemId());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{itemName:");
        stringBuilder.append(realmGet$itemName());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{itemCategory:");
        stringBuilder.append(realmGet$itemCategory());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{itemImageFileName:");
        stringBuilder.append(realmGet$itemImageFileName());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{itemAudioFileName:");
        stringBuilder.append(realmGet$itemAudioFileName());
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long rowIndex = proxyState.getRow$realm().getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        com_ceriosrey_chattrbox_ChattRItemRealmProxy aChattRItem = (com_ceriosrey_chattrbox_ChattRItemRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aChattRItem.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aChattRItem.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aChattRItem.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
