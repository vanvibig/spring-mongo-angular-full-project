import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Address} from '../model/address';

@Injectable({
    providedIn: 'root'
})
export class AddressService {

    constructor(
        private http: HttpClient
    ) {
    }

    getAll(): Observable<Address[]> {
        return this.http.get<Address[]>('/test/address');
    }

    create(address: Address): Observable<Address> {
        return this.http.post<Address>('/test/address', address);
    }

    delete(id: string): Observable<any> {
        return this.http.delete<any>(`/test/address/${id}`);
    }
}
