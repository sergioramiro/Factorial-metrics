import { useQuery } from "@tanstack/react-query";

const fetchChartMetrics = async (filter: string = "day") => {
  const response = await fetch(
    `http://localhost:8080/metrics/average?interval=${filter}`
  );
  if (!response.ok) {
    throw new Error("Network response was not ok");
  }
  return response.json();
};

export const useFetchChartMetrics = (filter: string) => {
  return useQuery({
    queryKey: ["chartMetrics"],
    queryFn: () => fetchChartMetrics(filter),
  });
};
