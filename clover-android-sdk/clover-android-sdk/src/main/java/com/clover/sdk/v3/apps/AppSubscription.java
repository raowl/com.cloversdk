/**
 * Copyright (C) 2015 Clover Network, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */

package com.clover.sdk.v3.apps;

import com.clover.sdk.GenericClient;

@SuppressWarnings("all")
public final class AppSubscription implements android.os.Parcelable, com.clover.sdk.v3.Validator, com.clover.sdk.JSONifiable {

 /**
  * Unique identifier
  */
  public java.lang.String getId() {
    return genClient.cacheGet(CacheKey.id);
  }
 /**
  * DEPRECATED: App subscription name.  Per country pricing in subscriptionCountries.
  */
  public java.lang.String getName() {
    return genClient.cacheGet(CacheKey.name);
  }
 /**
  * DEPRECATED: The cost of the subscription.  Per country pricing in subscriptionCountries.
  */
  public java.lang.Long getAmount() {
    return genClient.cacheGet(CacheKey.amount);
  }
 /**
  * DEPRECATED: App subscription name.  Per country pricing in subscriptionCountries.
  */
  public java.lang.String getDescription() {
    return genClient.cacheGet(CacheKey.description);
  }
 /**
  * DEPRECATED: App subscription active status.  Per country pricing in subscriptionCountries.
  */
  public java.lang.Boolean getActive() {
    return genClient.cacheGet(CacheKey.active);
  }
 /**
  * Subscription country options for this app subscription
  */
  public java.util.List<com.clover.sdk.v3.apps.AppSubscriptionCountry> getSubscriptionCountries() {
    return genClient.cacheGet(CacheKey.subscriptionCountries);
  }
 /**
  * Reference to app this subscription belongs to
  */
  public com.clover.sdk.v3.base.Reference getApp() {
    return genClient.cacheGet(CacheKey.app);
  }
 /**
  * App subscription label
  */
  public java.lang.String getLabel() {
    return genClient.cacheGet(CacheKey.label);
  }


  private enum CacheKey implements com.clover.sdk.ValueExtractorEnum<AppSubscription> {
    id {
      @Override
      public Object extractValue(AppSubscription instance) {
        return instance.genClient.extractOther("id", java.lang.String.class);
      }
    },
    name {
      @Override
      public Object extractValue(AppSubscription instance) {
        return instance.genClient.extractOther("name", java.lang.String.class);
      }
    },
    amount {
      @Override
      public Object extractValue(AppSubscription instance) {
        return instance.genClient.extractOther("amount", java.lang.Long.class);
      }
    },
    description {
      @Override
      public Object extractValue(AppSubscription instance) {
        return instance.genClient.extractOther("description", java.lang.String.class);
      }
    },
    active {
      @Override
      public Object extractValue(AppSubscription instance) {
        return instance.genClient.extractOther("active", java.lang.Boolean.class);
      }
    },
    subscriptionCountries {
      @Override
      public Object extractValue(AppSubscription instance) {
        return instance.genClient.extractListRecord("subscriptionCountries", com.clover.sdk.v3.apps.AppSubscriptionCountry.JSON_CREATOR);
      }
    },
    app {
      @Override
      public Object extractValue(AppSubscription instance) {
        return instance.genClient.extractRecord("app", com.clover.sdk.v3.base.Reference.JSON_CREATOR);
      }
    },
    label {
      @Override
      public Object extractValue(AppSubscription instance) {
        return instance.genClient.extractOther("label", java.lang.String.class);
      }
    },
    ;
  }

  private GenericClient<AppSubscription> genClient = new GenericClient<AppSubscription>(this);

  /**
   * Constructs a new empty instance.
   */
  public AppSubscription() { }

  /**
   * Constructs a new instance from the given JSON String.
   */
  public AppSubscription(String json) throws IllegalArgumentException {
    try {
      genClient.setJsonObject(new org.json.JSONObject(json));
    } catch (org.json.JSONException e) {
      throw new IllegalArgumentException("invalid json", e);
    }
  }

  /**
   * Construct a new instance backed by the given JSONObject, the parameter is not copied so changes to it will be
   * reflected in this instance and vice-versa.
   */
  public AppSubscription(org.json.JSONObject jsonObject) {
    genClient.setJsonObject(jsonObject);
  }

  /**
   * Constructs a new instance that is a deep copy of the source instance. It does not copy the bundle or changelog.
   */
  public AppSubscription(AppSubscription src) {
    if (src.genClient.getJsonObject() != null) {
      genClient.setJsonObject(com.clover.sdk.v3.JsonHelper.deepCopy(src.genClient.getJSONObject()));
    }
  }

  /**
   * Returns the internal JSONObject backing this instance, the return value is not a copy so changes to it will be
   * reflected in this instance and vice-versa.
   */
  public org.json.JSONObject getJSONObject() {
    return genClient.getJSONObject();
  }


  @Override
  public void validate() {
    genClient.validateLength(getId(), 13);

    genClient.validateLength(getName(), 20);

    if (getAmount() != null && ( getAmount() < 0)) throw new IllegalArgumentException("Invalid value for 'getAmount()'");

    genClient.validateLength(getDescription(), 1024);

    genClient.validateLength(getLabel(), 20);
  }

  /** Checks whether the 'id' field is set and is not null */
  public boolean isNotNullId() {
    return genClient.cacheValueIsNotNull(CacheKey.id);
  }

  /** Checks whether the 'name' field is set and is not null */
  public boolean isNotNullName() {
    return genClient.cacheValueIsNotNull(CacheKey.name);
  }

  /** Checks whether the 'amount' field is set and is not null */
  public boolean isNotNullAmount() {
    return genClient.cacheValueIsNotNull(CacheKey.amount);
  }

  /** Checks whether the 'description' field is set and is not null */
  public boolean isNotNullDescription() {
    return genClient.cacheValueIsNotNull(CacheKey.description);
  }

  /** Checks whether the 'active' field is set and is not null */
  public boolean isNotNullActive() {
    return genClient.cacheValueIsNotNull(CacheKey.active);
  }

  /** Checks whether the 'subscriptionCountries' field is set and is not null */
  public boolean isNotNullSubscriptionCountries() {
    return genClient.cacheValueIsNotNull(CacheKey.subscriptionCountries);
  }

  /** Checks whether the 'subscriptionCountries' field is set and is not null and is not empty */
  public boolean isNotEmptySubscriptionCountries() { return isNotNullSubscriptionCountries() && !getSubscriptionCountries().isEmpty(); }

  /** Checks whether the 'app' field is set and is not null */
  public boolean isNotNullApp() {
    return genClient.cacheValueIsNotNull(CacheKey.app);
  }

  /** Checks whether the 'label' field is set and is not null */
  public boolean isNotNullLabel() {
    return genClient.cacheValueIsNotNull(CacheKey.label);
  }


  /** Checks whether the 'id' field has been set, however the value could be null */
  public boolean hasId() {
    return genClient.cacheHasKey(CacheKey.id);
  }

  /** Checks whether the 'name' field has been set, however the value could be null */
  public boolean hasName() {
    return genClient.cacheHasKey(CacheKey.name);
  }

  /** Checks whether the 'amount' field has been set, however the value could be null */
  public boolean hasAmount() {
    return genClient.cacheHasKey(CacheKey.amount);
  }

  /** Checks whether the 'description' field has been set, however the value could be null */
  public boolean hasDescription() {
    return genClient.cacheHasKey(CacheKey.description);
  }

  /** Checks whether the 'active' field has been set, however the value could be null */
  public boolean hasActive() {
    return genClient.cacheHasKey(CacheKey.active);
  }

  /** Checks whether the 'subscriptionCountries' field has been set, however the value could be null */
  public boolean hasSubscriptionCountries() {
    return genClient.cacheHasKey(CacheKey.subscriptionCountries);
  }

  /** Checks whether the 'app' field has been set, however the value could be null */
  public boolean hasApp() {
    return genClient.cacheHasKey(CacheKey.app);
  }

  /** Checks whether the 'label' field has been set, however the value could be null */
  public boolean hasLabel() {
    return genClient.cacheHasKey(CacheKey.label);
  }


  /**
   * Sets the field 'id'.
   */
  public AppSubscription setId(java.lang.String id) {
    return genClient.setOther(id, CacheKey.id);
  }

  /**
   * Sets the field 'name'.
   */
  public AppSubscription setName(java.lang.String name) {
    return genClient.setOther(name, CacheKey.name);
  }

  /**
   * Sets the field 'amount'.
   */
  public AppSubscription setAmount(java.lang.Long amount) {
    return genClient.setOther(amount, CacheKey.amount);
  }

  /**
   * Sets the field 'description'.
   */
  public AppSubscription setDescription(java.lang.String description) {
    return genClient.setOther(description, CacheKey.description);
  }

  /**
   * Sets the field 'active'.
   */
  public AppSubscription setActive(java.lang.Boolean active) {
    return genClient.setOther(active, CacheKey.active);
  }

  /**
   * Sets the field 'subscriptionCountries'.
   *
   * Nulls in the given List are skipped. List parameter is copied, so it will not reflect any changes, but objects inside it will.
   */
  public AppSubscription setSubscriptionCountries(java.util.List<com.clover.sdk.v3.apps.AppSubscriptionCountry> subscriptionCountries) {
    return genClient.setArrayRecord(subscriptionCountries, CacheKey.subscriptionCountries);
  }

  /**
   * Sets the field 'app'.
   *
   * The parameter is not copied so changes to it will be reflected in this instance and vice-versa.
   */
  public AppSubscription setApp(com.clover.sdk.v3.base.Reference app) {
    return genClient.setRecord(app, CacheKey.app);
  }

  /**
   * Sets the field 'label'.
   */
  public AppSubscription setLabel(java.lang.String label) {
    return genClient.setOther(label, CacheKey.label);
  }


  /** Clears the 'id' field, the 'has' method for this field will now return false */
  public void clearId() {
    genClient.clear(CacheKey.id);
  }
  /** Clears the 'name' field, the 'has' method for this field will now return false */
  public void clearName() {
    genClient.clear(CacheKey.name);
  }
  /** Clears the 'amount' field, the 'has' method for this field will now return false */
  public void clearAmount() {
    genClient.clear(CacheKey.amount);
  }
  /** Clears the 'description' field, the 'has' method for this field will now return false */
  public void clearDescription() {
    genClient.clear(CacheKey.description);
  }
  /** Clears the 'active' field, the 'has' method for this field will now return false */
  public void clearActive() {
    genClient.clear(CacheKey.active);
  }
  /** Clears the 'subscriptionCountries' field, the 'has' method for this field will now return false */
  public void clearSubscriptionCountries() {
    genClient.clear(CacheKey.subscriptionCountries);
  }
  /** Clears the 'app' field, the 'has' method for this field will now return false */
  public void clearApp() {
    genClient.clear(CacheKey.app);
  }
  /** Clears the 'label' field, the 'has' method for this field will now return false */
  public void clearLabel() {
    genClient.clear(CacheKey.label);
  }


  /**
   * Returns true if this instance has any changes.
   */
  public boolean containsChanges() {
    return genClient.containsChanges();
  }

  /**
   * Reset the log of changes made to this instance, calling copyChanges() after this would return an empty instance.
   */
  public void resetChangeLog() {
    genClient.resetChangeLog();
  }

  /**
   * Create a copy of this instance that contains only fields that were set after the constructor was called.
   */
  public AppSubscription copyChanges() {
    AppSubscription copy = new AppSubscription();
    copy.mergeChanges(this);
    copy.resetChangeLog();
    return copy;
  }

  /**
   * Copy all the changed fields from the given source to this instance.
   */
  public void mergeChanges(AppSubscription src) {
    if (src.genClient.getChangeLog() != null) {
      genClient.mergeChanges(new AppSubscription(src).getJSONObject(), src.genClient);
    }
  }

  /**
   * Gets a Bundle which can be used to get and set data attached to this instance. The attached Bundle will be
   * parcelled but not jsonified.
   */
  public android.os.Bundle getBundle() {
    return genClient.getBundle();
  }

  @Override
  public String toString() {
    return genClient.toString();
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(android.os.Parcel dest, int flags) {
    genClient.writeToParcel(dest, flags);
  }

  public static final android.os.Parcelable.Creator<AppSubscription> CREATOR = new android.os.Parcelable.Creator<AppSubscription>() {
    @Override
    public AppSubscription createFromParcel(android.os.Parcel in) {
      AppSubscription instance = new AppSubscription(com.clover.sdk.v3.JsonParcelHelper.ObjectWrapper.CREATOR.createFromParcel(in).unwrap());
      instance.genClient.setBundle(in.readBundle(getClass().getClassLoader()));
      instance.genClient.setChangeLog(in.readBundle());
      return instance;
    }

    @Override
    public AppSubscription[] newArray(int size) {
      return new AppSubscription[size];
    }
  };

  public static final com.clover.sdk.JSONifiable.Creator<AppSubscription> JSON_CREATOR = new com.clover.sdk.JSONifiable.Creator<AppSubscription>() {
    @Override
    public AppSubscription create(org.json.JSONObject jsonObject) {
      return new AppSubscription(jsonObject);
    }
  };


  public interface Constraints {

    public static final boolean ID_IS_REQUIRED = false;
    public static final long ID_MAX_LEN = 13;

    public static final boolean NAME_IS_REQUIRED = false;
    public static final long NAME_MAX_LEN = 20;

    public static final boolean AMOUNT_IS_REQUIRED = false;
    public static final long AMOUNT_MIN = 0;

    public static final boolean DESCRIPTION_IS_REQUIRED = false;
    public static final long DESCRIPTION_MAX_LEN = 1024;

    public static final boolean ACTIVE_IS_REQUIRED = false;

    public static final boolean SUBSCRIPTIONCOUNTRIES_IS_REQUIRED = false;

    public static final boolean APP_IS_REQUIRED = false;

    public static final boolean LABEL_IS_REQUIRED = false;
    public static final long LABEL_MAX_LEN = 20;

  }

}
