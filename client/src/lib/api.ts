import { Medicine } from "../ts/interfaces/medicine.interface";
const API_URL = "http://localhost:3000/api/v1/medicines";

async function handleResponse<T>(response: Response): Promise<T> {
  if (!response.ok) {
    const error = await response.text();
    throw new Error(error || response.statusText);
  }
  return response.json();
}

export const getMedicines = async (): Promise<Medicine[]> => {
  const response = await fetch(`${API_URL}/medicines`);
  return handleResponse<Medicine[]>(response);
};

export const createMedicine = async (
  medicine: Omit<Medicine, "id">
): Promise<Medicine> => {
  const response = await fetch(`${API_URL}/medicines`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(medicine),
  });
  return handleResponse<Medicine>(response);
};

export const updateMedicine = async (medicine: Medicine): Promise<Medicine> => {
  const response = await fetch(`${API_URL}/medicines/${medicine.id}`, {
    method: "PUT",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(medicine),
  });
  return handleResponse<Medicine>(response);
};

export const deleteMedicine = async (id: number): Promise<void> => {
  const response = await fetch(`${API_URL}/medicines/${id}`, {
    method: "DELETE",
  });
  await handleResponse<void>(response);
};
