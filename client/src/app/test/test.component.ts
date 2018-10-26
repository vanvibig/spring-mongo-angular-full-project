import {Component, OnInit} from '@angular/core';
import {TestService} from './test.service';
import {AddressService} from '../service/address.service';
import {StudentService} from '../service/student.service';
import {Address} from '../model/address';
import {Student} from '../model/student';
import {map, switchMap} from 'rxjs/operators';

@Component({
    selector: 'app-test',
    templateUrl: './test.component.html',
    styleUrls: ['./test.component.css']
})
export class TestComponent implements OnInit {

    city: string;
    name: string;
    address: Address = {};
    student: Student = {};
    addresses: Address[] = [];
    students: Student[] = [];

    constructor(
        private addressService: AddressService,
        private studentService: StudentService
    ) {
        this.loadEntities();
    }

    loadEntities() {
        this.addressService.getAll().subscribe((res: Address[]) => {
            this.addresses = res;
        });

        this.studentService.getAll().subscribe((res: Student[]) => {
            this.students = res;
        });
    }

    ngOnInit() {
    }

    reset() {
        this.address = {};
        this.student = {};
    }

    reLoad(address: Address, student: Student) {
        this.addresses.push(address);
        this.students.push(student);
    }

    async save() {
        const addressSaved = await this.addressService.create(this.address).toPromise();
        this.student.addressId = addressSaved.id;
        const studentSaved = await this.studentService.create(this.student).toPromise();
        this.reLoad(addressSaved, studentSaved);
        this.reset();
    }

    deleteAddress(id: string) {
        this.addressService.delete(id).subscribe().unsubscribe();
        const position = this.addresses.findIndex((addressEL: Address) => {
            return addressEL.id === id;
        });
        this.addresses.splice(position, 1);
    }

    deleteStudent(id: string) {
        this.studentService.delete(id).subscribe().unsubscribe();
        const position = this.addresses.findIndex((studentEL: Student) => {
            return studentEL.id === id;
        });
        this.students.splice(position, 1);
    }
}
