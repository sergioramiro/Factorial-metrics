import { useQuery } from "@tanstack/react-query";

const getChartMetrics = async (filter: string = "day") => {
  const response = await fetch(
    `http://localhost:8080/metrics/average?interval=${filter}`
  );
  if (!response.ok) {
    throw new Error("Network response was not ok");
  }
  return response.json();
};

export const useGetChartMetrics = (filter: string) => {
  return useQuery({
    queryKey: ["chartMetrics"],
    queryFn: () => getChartMetrics(filter),
  });
};
