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
import { UserData } from "../data";

const Chart: React.FC = () => {
  return (
    <div className="h-full w-full flex justify-center items-center bg-gray-200 rounded-md p-4 mb-4">
      <LineChart width={1200} height={600} data={UserData}>
        <CartesianGrid strokeDasharray="5 5" />
        <XAxis dataKey="time" padding={{ left: 30, right: 30 }} />
        <YAxis />
        <Tooltip />
        <Legend verticalAlign="top" height={36} iconType="diamond" />
        <Line
          type="monotone"
          dataKey="temperature"
          stroke="#8884d8"
          activeDot={{ r: 8 }}
          strokeWidth={3}
        />
        <Line type="monotone" dataKey="humidity" stroke="#82ca9d" />
      </LineChart>
    </div>
  );
};

export default Chart;
