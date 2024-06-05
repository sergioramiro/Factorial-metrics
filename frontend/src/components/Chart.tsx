import React, { useState, useEffect } from "react";
import {
  LineChart,
  Line,
  XAxis,
  YAxis,
  CartesianGrid,
  Tooltip,
  Legend,
} from "recharts";
import { useFetchChartMetrics } from "../hooks/useFetchChartMetrics";
import { JSX } from "react/jsx-runtime";

interface ChartProps {
  names: string[];
}

const Chart: React.FC<ChartProps> = ({ names }) => {
  const [filter, setFilter] = useState("day");
  const { data, error, isLoading, refetch } = useFetchChartMetrics(filter);

  useEffect(() => {
    refetch();
  }, [filter, refetch]);

  if (isLoading) return <div>Loading...</div>;
  if (error) return <div>Error: {error.message}</div>;
  const lines: JSX.Element[] = [];

  names.forEach((serie, index) => {
    lines.push(
      <Line
        key={index}
        type="monotone"
        dataKey={serie}
        stroke={`#${Math.floor(Math.random() * 16777215).toString(16)}`}
        activeDot={{ r: 8 }}
        strokeWidth={3}
      />
    );
  });

  return (
    <div className="h-full w-full justify-center items-center bg-gray-200 rounded-md p-4 mb-4">
      <LineChart width={1200} height={600} data={data}>
        <CartesianGrid strokeDasharray="5 5" />
        <XAxis dataKey="time" padding={{ left: 30, right: 30 }} />
        <YAxis />
        <Tooltip />
        <Legend verticalAlign="top" height={36} iconType="diamond" />
        {lines}
      </LineChart>
      <div className="my-4">
        <div className="flex justify-center items-center py-4">
          <div className="mr-4">
            <label className="mr-2">
              <input
                type="radio"
                name="chartType"
                value="minute"
                className="mr-1"
                onClick={(e) => {
                  setFilter((e.target as HTMLInputElement).value);
                }}
              />
              MINUTOS
            </label>
            <label className="mr-2">
              <input
                type="radio"
                name="chartType"
                value="hour"
                className="mr-1"
                onClick={(e) => {
                  setFilter((e.target as HTMLInputElement).value);
                }}
              />
              HORAS
            </label>
            <label className="mr-2">
              <input
                type="radio"
                name="chartType"
                value="day"
                className="mr-1"
                defaultChecked
                onClick={(e) => {
                  setFilter((e.target as HTMLInputElement).value);
                }}
              />
              DIAS
            </label>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Chart;
