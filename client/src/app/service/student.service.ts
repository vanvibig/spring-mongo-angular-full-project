import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Student} from '../model/student';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

    constructor(
        private http: HttpClient
    ) {
    }

    getAll(): Observable<Student[]> {
        return this.http.get<Student[]>('/test/student');
    }

    create(student: Student): Observable<Student> {
        return this.http.post<Student>('/test/student', student);
    }

    delete(id: string): Observable<any> {
        return this.http.delete<any>(`/test/student/${id}`);
    }
}
