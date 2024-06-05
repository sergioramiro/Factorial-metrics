import React, { useState } from "react";
// import { useFetchAddMetric } from "../hooks/useFetchAddMetric";

const CreateMetric: React.FC = () => {
  const [name, setName] = useState("");
  const [value, setValue] = useState("");
//   const { data, error, isLoading } = useFetchAddMetric({name, value});


  const isButtonDisabled = name === "" || value === "";

  return (
    <div className="my-4">
      <div className="flex justify-center items-center py-4">
        <input
          type="text"
          placeholder="Nombre"
          className="border border-gray-300 rounded px-4 py-2 mr-2"
          value={name}
          onChange={(e) => setName(e.target.value)}
        />
        <input
          type="text"
          placeholder="Valor"
          className="border border-gray-300 rounded px-4 py-2 mr-2"
          value={value}
          onChange={(e) => setValue(e.target.value)}
        />
        <button
          className={`bg-factorial  text-white font-bold py-2 px-4 rounded ${
            isButtonDisabled ? "opacity-50 cursor-not-allowed" : ""
          }`}
          disabled={isButtonDisabled}
        //   onClick={handleSubmit}
        >
          Añadir
        </button>
      </div>
    </div>
  );
};

export default CreateMetric;
