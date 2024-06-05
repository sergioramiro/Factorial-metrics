const CreateMetric: React.FC = () => {
  return (
    <div className="my-4">
      <div className="flex justify-center items-center py-4">
        <input
          type="text"
          placeholder="Nombre"
          className="border border-gray-300 rounded px-4 py-2 mr-2"
        />
        <input
          type="text"
          placeholder="Valor"
          className="border border-gray-300 rounded px-4 py-2 mr-2"
        />
        <button className="bg-factorial hover:bg-factorial-500 text-white font-bold py-2 px-4 rounded">
          Añadir
        </button>
      </div>
    </div>
  );
};

export default CreateMetric;
