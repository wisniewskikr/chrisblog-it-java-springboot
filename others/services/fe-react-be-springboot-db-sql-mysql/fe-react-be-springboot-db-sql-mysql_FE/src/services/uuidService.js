import { v4 as uuidv4 } from 'uuid';

const UUID_KEY = 'fixed_uuid';

const getFixedUUID = () => {
  // Check if UUID exists in localStorage
  let uuid = localStorage.getItem(UUID_KEY);

  // If not, generate a new one and save it
  if (!uuid) {
    uuid = uuidv4();
    localStorage.setItem(UUID_KEY, uuid);
  }

  return uuid;
};

export default getFixedUUID;