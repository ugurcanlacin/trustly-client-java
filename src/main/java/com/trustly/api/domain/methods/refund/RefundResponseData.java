package com.trustly.api.domain.methods.refund;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.trustly.api.domain.base.AbstractResponseResultData;
import com.trustly.api.domain.base.JsonRpcResponse;
import com.trustly.api.domain.common.StringBooleanDeserializer;
import com.trustly.api.domain.common.StringBooleanSerializer;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

@Value
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@Jacksonized
public class RefundResponseData extends AbstractResponseResultData {

  /**
   * The OrderID specified when calling the method.
   */
  @JsonProperty("orderid")
  long orderId;

  /**
   * "1" if the refund request is accepted by Trustly's system.
   * <p>
   * If the refund request is not accepted, you will get an error code back in {@link JsonRpcResponse#getError()}.
   */
  @JsonProperty("result")
  @JsonSerialize(using = StringBooleanSerializer.class)
  @JsonDeserialize(using = StringBooleanDeserializer.class)
  boolean result;
}
