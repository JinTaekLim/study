package com.study.study;

import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CustomerRepository {

  private final ListOperations<String, Map<String, String>> listOperations;
  private final String INSTITUTE_PREFIX = "institute:";
  private final int MAX_SIZE = 19;

  private String getKey(Long instituteId) {
    return INSTITUTE_PREFIX + instituteId;
  }

  public void add(
      Dto req
  ) {
    String key = getKey(req.getInstituteId());

    Map<String, String> reservationData = Map.of(
        "customerId", String.valueOf(req.getCustomerId()),
        "reservationId", String.valueOf(req.getReservationId()),
        "usedTime", String.valueOf(req.getUsedTime()),
        "lateCount", String.valueOf(req.getLateCount()),
        "absenceCount", String.valueOf(req.getAbsenceCount())
    );


    listOperations.leftPush(key, reservationData);
    listOperations.trim(key, 0, MAX_SIZE);
  }

  public List<Dto> findByInstituteId(Long instituteId) {
    String key = getKey(instituteId);
    List<Map<String, String>> map = listOperations.range(key, 0, MAX_SIZE);

    if (map == null) { return null; }

    return map.stream().map(m -> {
      Long reservationId = Long.valueOf(m.get("reservationId"));
      Long customerId = Long.valueOf(m.get("customerId"));
      double usedTime = Double.parseDouble(m.get("usedTime"));
      int lateCount = Integer.parseInt(m.get("lateCount"));
      int absenceCount = Integer.parseInt(m.get("absenceCount"));

      return Dto.builder()
          .instituteId(instituteId)
          .customerId(customerId)
          .reservationId(reservationId)
          .usedTime(usedTime)
          .lateCount(lateCount)
          .absenceCount(absenceCount)
          .build();
    }).toList();
  }


}
