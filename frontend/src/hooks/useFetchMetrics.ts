import { useQuery } from "@tanstack/react-query";

const fetchMetrics = async () => {
  const response = await fetch(
    "http://localhost:8080/metrics"
  );
  if (!response.ok) {
    throw new Error('Network response was not ok');
  }
  return response.json();
};

export const useFetchMetrics = () => {
  return useQuery({
    queryKey: ["metrics"],
    queryFn: fetchMetrics,
  });
};