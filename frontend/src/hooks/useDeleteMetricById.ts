import { useMutation, useQueryClient } from "@tanstack/react-query";

const deleteMetric = async (id: number) => {
  await fetch(`http://localhost:8080/metrics/${id}`, {
    method: "DELETE",
  });
};

const useDeteleMetricById = () => {
  const queryClient = useQueryClient();

  const mutation = useMutation({
    mutationFn: (id: number) => {
      return deleteMetric(id);
    },
    onSuccess: async () => {
      await queryClient.fetchQuery({ queryKey: ["metrics"] });
      await queryClient.fetchQuery({ queryKey: ["chartMetrics"] });
      await queryClient.fetchQuery({ queryKey: ["allNames"] });
    },
  });

  const deleteRecord = (id: number) => {
    if (window.confirm("Are you sure you want to delete this record?")) {
      mutation.mutate(id);
    }
  };
  return { deleteRecord, ...mutation };
};

export default useDeteleMetricById;
