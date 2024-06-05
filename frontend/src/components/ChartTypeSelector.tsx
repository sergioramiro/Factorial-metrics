const ChartTypeSelector: React.FC = () => {
  return (
    <div className="my-4">
      <div className="flex justify-center items-center py-4">
        <div className="mr-4">
          <label className="mr-2">
            <input
              type="radio"
              name="chartType"
              value="minuto"
              className="mr-1"
            />
            Minuto
          </label>
          <label className="mr-2">
            <input
              type="radio"
              name="chartType"
              value="hora"
              className="mr-1"
            />
            Hora
          </label>
          <label className="mr-2">
            <input type="radio" name="chartType" value="dia" className="mr-1" />
            Día
          </label>
        </div>
      </div>
    </div>
  );
};

export default ChartTypeSelector;
