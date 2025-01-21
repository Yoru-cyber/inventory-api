import { BrowserRouter, Route, Routes } from "react-router";
import Index from "./pages";
import ProvidersIndex from "./pages/providers";
import Navbar from "./components/navbar";
import MedicinesIndex from "./pages/medicines";
function App() {
  return (
    <>

      <BrowserRouter>
        <div className="min-h-screen bg-gray-50">
          <Navbar />
          <Routes>
            <Route path="/" element={<Index />}></Route>
            <Route path="/medicine" element={<MedicinesIndex />}></Route>
            <Route path="/providers" element={<ProvidersIndex />}></Route>
          </Routes>
        </div>
      </BrowserRouter>
    </>
  );
}

export default App
