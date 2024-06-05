import { useQuery } from "@tanstack/react-query";

const fetchChartMetrics = async () => {
  const response = await fetch("http://localhost:8080/metrics/average?interval=day");
  if (!response.ok) {
    throw new Error("Network response was not ok");
  }
  return response.json();
};

export const useFetchChartMetrics = () => {
  return useQuery({
    queryKey: ["chartMetrics"],
    queryFn: fetchChartMetrics,
  });
};
