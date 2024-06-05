import React from "react";
import {
  LineChart,
  Line,
  XAxis,
  YAxis,
  CartesianGrid,
  Tooltip,
  Legend,
} from "recharts";
import ChartTypeSelector from "./ChartTypeSelector";
import { UserData } from "../data";
import { JSX } from "react/jsx-runtime";

interface ChartProps {
  data: string[];
}

const Chart: React.FC<ChartProps> = ({ data }) => {
  const lines: JSX.Element[] = [];

  data.forEach((serie, index) => {
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
      <LineChart width={1200} height={600} data={UserData}>
        <CartesianGrid strokeDasharray="5 5" />
        <XAxis dataKey="time" padding={{ left: 30, right: 30 }} />
        <YAxis />
        <Tooltip />
        <Legend verticalAlign="top" height={36} iconType="diamond" />
        {lines}
      </LineChart>
      <ChartTypeSelector />
    </div>
  );
};

export default Chart;
