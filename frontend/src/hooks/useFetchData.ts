import { useQuery } from "@tanstack/react-query";

const fetchUserData = async () => {
  const response = await fetch("http://localhost:8080/metrics/names");
  return response.json();
};

export const useFetchUserData = () => {
  return useQuery({
    queryKey: ["userData"],
    queryFn: fetchUserData,
  });
};
