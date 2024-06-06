import { useQuery } from "@tanstack/react-query";

const getAllMetrics = async () => {
  const response = await fetch("http://localhost:8080/metrics");
  if (!response.ok) {
    throw new Error("Network response was not ok");
  }
  return response.json();
};

export const useGetAllMetrics = () => {
  return useQuery({
    queryKey: ["metrics"],
    queryFn: getAllMetrics,
  });
};
