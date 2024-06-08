import { useQuery } from "@tanstack/react-query";

const getAllNames = async () => {
  const response = await fetch("http://localhost:8080/metrics/names");
  return response.json();
};

export const useGetAllNames = () => {
  return useQuery({
    queryKey: ["allnames"],
    queryFn: getAllNames,
  });
};
