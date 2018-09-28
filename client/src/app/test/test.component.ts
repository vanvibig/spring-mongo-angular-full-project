import {Component, OnInit} from '@angular/core';
import {TestService} from './test.service';

@Component({
    selector: 'app-test',
    templateUrl: './test.component.html',
    styleUrls: ['./test.component.css']
})
export class TestComponent implements OnInit {

    hello: any;

    constructor(private testService: TestService) {
    }

    ngOnInit() {
        this.testService.getHello().subscribe(
            (res) => {
                this.hello = res;
            }
        );
    }

}
