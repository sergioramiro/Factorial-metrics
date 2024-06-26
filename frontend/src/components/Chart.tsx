import React, { useState, useEffect, Fragment } from "react";
import {
  LineChart,
  Line,
  XAxis,
  YAxis,
  CartesianGrid,
  Tooltip,
  Legend,
} from "recharts";
import { useGetChartMetrics } from "../hooks/useGetChartMetrics";
import { JSX } from "react/jsx-runtime";

interface ChartProps {
  names: string[];
}

const colors = ["#ff345c", "#0A38FA", "#FABD0A", "#0AFA33", "#A58B3E"];

const labelFilters = [
  {
    text: "MINUTOS",
    value: "minute",
    default: false,
  },
  {
    text: "HORAS",
    value: "hour",
    default: false,
  },
  {
    text: "DIAS",
    value: "day",
    default: true,
  },
];

const Chart: React.FC<ChartProps> = ({ names }) => {
  const [filter, setFilter] = useState("day");
  const { data, error, isLoading, refetch } = useGetChartMetrics(filter);

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
        stroke={colors[index % colors.length]}
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
            {labelFilters.map((item, idx) => {
              return (
                <Fragment key={idx}>
                  <label className="mr-2">
                    <input
                      type="radio"
                      name="chartType"
                      value={item.value}
                      className="mr-1"
                      defaultChecked={item.default}
                      onClick={() => {
                        setFilter(item.value);
                      }}
                    />
                    {item.text}
                  </label>
                </Fragment>
              );
            })}
          </div>
        </div>
      </div>
    </div>
  );
};

export default Chart;
