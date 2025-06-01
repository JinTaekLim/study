import http from "k6/http";
import { check } from "k6";

export const options = {
  vus: 250,
  duration: "5m",
  thresholds: {
    http_req_duration: ["p(95)<100"],
  },
};

export default function () {
  const response = http.get("http://localhost:8080/api/test");

  check(response, {
    "status is 200": (res) => res.status === 200,
  });
}
