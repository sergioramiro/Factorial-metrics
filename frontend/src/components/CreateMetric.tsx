import React, { useState } from "react";
import { useAddMetric } from "../hooks/useAddMetric";

const CreateMetric: React.FC = () => {
  const [name, setName] = useState("");
  const [value, setValue] = useState("");
  const { handleSubmit } = useAddMetric();

  const isButtonDisabled = name === "" || value === "";

  return (
    <div className="my-4">
      <div className="flex justify-center items-center py-4">
        <form onSubmit={(e) => handleSubmit(e)}>
          <input
            name="name"
            type="text"
            placeholder="Nombre"
            className="border border-gray-300 rounded px-4 py-2 mr-2"
            value={name}
            onChange={(e) => setName(e.target.value)}
          />
          <input
            name="value"
            type="number"
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
          >
            Añadir
          </button>
        </form>
      </div>
    </div>
  );
};

export default CreateMetric;
