import { useMutation, useQueryClient } from "@tanstack/react-query";

interface Metric {
  name: string;
  value: number;
}

const postAddMetric = async (metric: Metric) => {
  const response = await fetch(`http://localhost:8080/metrics`, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(metric),
  });

  if (!response.ok) {
    throw new Error("Network response was not ok");
  }
  return response.json();
};

export const useAddMetric = () => {
  const queryClient = useQueryClient();
  const mutation = useMutation({
    mutationFn: (metric: any) => {
      return postAddMetric(metric);
    },
    onSuccess: async () => {
      await queryClient.fetchQuery({ queryKey: ["metrics"] });
      await queryClient.fetchQuery({ queryKey: ["chartMetrics"] });
      await queryClient.fetchQuery({ queryKey: ["allNames"] });
    },
  });

  const handleSubmit = (event: any) => {
    event.preventDefault();
    const formData = new FormData(event.target as HTMLFormElement);
    const entries = Object.fromEntries(formData);
    mutation.mutate(entries);
  };
  return { handleSubmit, mutation };
};
