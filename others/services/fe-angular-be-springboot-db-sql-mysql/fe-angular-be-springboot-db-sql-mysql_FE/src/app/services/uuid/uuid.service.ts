import { Injectable } from '@angular/core';
import { v4 as uuidv4 } from 'uuid';

@Injectable({
  providedIn: 'root'
})
export class UuidService {
  
  private uuid: string;

  constructor() {
    this.uuid = this.loadUUID();
  }

  private loadUUID(): string {
    let storedUuid = localStorage.getItem('app-uuid');
    if (!storedUuid) {
      storedUuid = uuidv4();
      localStorage.setItem('app-uuid', storedUuid);
    }
    return storedUuid;
  }

  getUUID(): string {
    return this.uuid;
  }

}
