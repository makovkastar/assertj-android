// Copyright 2013 Square, Inc.
package org.assertj.android.api.location;

import android.annotation.TargetApi;
import android.location.Criteria;
import org.assertj.core.api.AbstractAssert;

import static android.location.Criteria.ACCURACY_COARSE;
import static android.location.Criteria.ACCURACY_FINE;
import static android.location.Criteria.ACCURACY_HIGH;
import static android.location.Criteria.ACCURACY_LOW;
import static android.location.Criteria.ACCURACY_MEDIUM;
import static android.location.Criteria.NO_REQUIREMENT;
import static android.location.Criteria.POWER_HIGH;
import static android.location.Criteria.POWER_LOW;
import static android.location.Criteria.POWER_MEDIUM;
import static android.os.Build.VERSION_CODES.GINGERBREAD;
import static org.assertj.core.api.Assertions.assertThat;

/** Assertions for {@link Criteria} instances. */
public class CriteriaAssert extends AbstractAssert<CriteriaAssert, Criteria> {
  public CriteriaAssert(Criteria actual) {
    super(actual, CriteriaAssert.class);
  }

  public CriteriaAssert hasAccuracy(int accuracy) {
    isNotNull();
    int actualAccuracy = actual.getAccuracy();
    //noinspection ResourceType
    assertThat(actualAccuracy) //
        .overridingErrorMessage("Expected accuracy <%s> but was <%s>.",
            accuracyRequirementToString(accuracy), accuracyRequirementToString(actualAccuracy)) //
        .isEqualTo(accuracy);
    return this;
  }

  @TargetApi(GINGERBREAD)
  public CriteriaAssert hasBearingAccuracy(int accuracy) {
    isNotNull();
    int actualAccuracy = actual.getBearingAccuracy();
    //noinspection ResourceType
    assertThat(actualAccuracy) //
        .overridingErrorMessage("Expected bearing accuracy <%s> but was <%s>.",
            accuracyToString(accuracy), accuracyToString(actualAccuracy)) //
        .isEqualTo(accuracy);
    return this;
  }

  @TargetApi(GINGERBREAD)
  public CriteriaAssert hasHorizontalAccuracy(int accuracy) {
    isNotNull();
    int actualAccuracy = actual.getHorizontalAccuracy();
    //noinspection ResourceType
    assertThat(actualAccuracy) //
        .overridingErrorMessage("Expected horizontal accuracy <%s> but was <%s>.",
            accuracyToString(accuracy), accuracyToString(actualAccuracy)) //
        .isEqualTo(accuracy);
    return this;
  }

  public CriteriaAssert hasPowerRequirement(int requirement) {
    isNotNull();
    int actualRequirement = actual.getPowerRequirement();
    //noinspection ResourceType
    assertThat(actualRequirement) //
        .overridingErrorMessage("Expected power requirement <%s> but was <%s>.",
            powerRequirementToString(requirement), powerRequirementToString(actualRequirement)) //
        .isEqualTo(requirement);
    return this;
  }

  @TargetApi(GINGERBREAD)
  public CriteriaAssert hasSpeedAccuracy(int accuracy) {
    isNotNull();
    int actualAccuracy = actual.getSpeedAccuracy();
    //noinspection ResourceType
    assertThat(actualAccuracy) //
        .overridingErrorMessage("Expected speed accuracy <%s> but was <%s>.",
            accuracyToString(accuracy), accuracyToString(actualAccuracy)) //
        .isEqualTo(accuracy);
    return this;
  }

  @TargetApi(GINGERBREAD)
  public CriteriaAssert hasVerticalAccuracy(int accuracy) {
    isNotNull();
    int actualAccuracy = actual.getVerticalAccuracy();
    //noinspection ResourceType
    assertThat(actualAccuracy) //
        .overridingErrorMessage("Expected vertical accuracy <%s> but was <%s>.",
            accuracyToString(accuracy), accuracyToString(actualAccuracy)) //
        .isEqualTo(accuracy);
    return this;
  }

  public CriteriaAssert isAltitudeRequired() {
    isNotNull();
    assertThat(actual.isAltitudeRequired()) //
        .overridingErrorMessage("Expected altitude to be required but was not.") //
        .isTrue();
    return this;
  }

  public CriteriaAssert isAltitudeNotRequired() {
    isNotNull();
    assertThat(actual.isAltitudeRequired()) //
        .overridingErrorMessage("Expected altitude to not be required but was.") //
        .isFalse();
    return this;
  }

  public CriteriaAssert isBearingRequired() {
    isNotNull();
    assertThat(actual.isBearingRequired()) //
        .overridingErrorMessage("Expected bearing to be required but was not.") //
        .isTrue();
    return this;
  }

  public CriteriaAssert isBearingNotRequired() {
    isNotNull();
    assertThat(actual.isBearingRequired()) //
        .overridingErrorMessage("Expected bearing to not be required but was.") //
        .isFalse();
    return this;
  }

  public CriteriaAssert isCostAllowed() {
    isNotNull();
    assertThat(actual.isCostAllowed()) //
        .overridingErrorMessage("Expected cost to be allowed but was not.") //
        .isTrue();
    return this;
  }

  public CriteriaAssert isCostNotAllowed() {
    isNotNull();
    assertThat(actual.isCostAllowed()) //
        .overridingErrorMessage("Expected cost to not be allowed but was.") //
        .isFalse();
    return this;
  }

  public CriteriaAssert isSpeedRequired() {
    isNotNull();
    assertThat(actual.isSpeedRequired()) //
        .overridingErrorMessage("Expected speed to be required but was not.") //
        .isTrue();
    return this;
  }

  public CriteriaAssert isSpeedNotRequired() {
    isNotNull();
    assertThat(actual.isSpeedRequired()) //
        .overridingErrorMessage("Expected speed to not be required but was.") //
        .isFalse();
    return this;
  }

  static String accuracyRequirementToString(@CriteriaAccuracyRequirement int accuracy) {
    switch (accuracy) {
      case ACCURACY_COARSE:
        return "coarse";
      case ACCURACY_FINE:
        return "fine";
      default:
        throw new IllegalArgumentException("Unknown accuracy requirement: " + accuracy);
    }
  }

  private static String accuracyToString(@CriteriaAccuracy int accuracy) {
    switch (accuracy) {
      case ACCURACY_HIGH:
        return "high";
      case ACCURACY_MEDIUM:
        return "medium";
      case ACCURACY_LOW:
        return "low";
      default:
        throw new IllegalArgumentException("Unknown accuracy: " + accuracy);
    }
  }

  static String powerRequirementToString(@CriteriaPowerRequirement int requirement) {
    switch (requirement) {
      case NO_REQUIREMENT:
        return "none";
      case POWER_LOW:
        return "low";
      case POWER_MEDIUM:
        return "medium";
      case POWER_HIGH:
        return "high";
      default:
        throw new IllegalArgumentException("Unknown power requirement: " + requirement);
    }
  }
}
