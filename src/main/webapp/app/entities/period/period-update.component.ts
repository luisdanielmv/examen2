import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import * as moment from 'moment';

import { IPeriod } from 'app/shared/model/period.model';
import { PeriodService } from './period.service';

@Component({
    selector: 'jhi-period-update',
    templateUrl: './period-update.component.html'
})
export class PeriodUpdateComponent implements OnInit {
    period: IPeriod;
    isSaving: boolean;
    startDateDp: any;
    endDateDp: any;

    constructor(protected periodService: PeriodService, protected activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ period }) => {
            this.period = period;
        });
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        if (this.period.id !== undefined) {
            this.subscribeToSaveResponse(this.periodService.update(this.period));
        } else {
            this.subscribeToSaveResponse(this.periodService.create(this.period));
        }
    }

    protected subscribeToSaveResponse(result: Observable<HttpResponse<IPeriod>>) {
        result.subscribe((res: HttpResponse<IPeriod>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
    }

    protected onSaveSuccess() {
        this.isSaving = false;
        this.previousState();
    }

    protected onSaveError() {
        this.isSaving = false;
    }
}
