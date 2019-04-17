import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { Examen2SharedModule } from 'app/shared';
import {
    PeriodComponent,
    PeriodDetailComponent,
    PeriodUpdateComponent,
    PeriodDeletePopupComponent,
    PeriodDeleteDialogComponent,
    periodRoute,
    periodPopupRoute
} from './';

const ENTITY_STATES = [...periodRoute, ...periodPopupRoute];

@NgModule({
    imports: [Examen2SharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [PeriodComponent, PeriodDetailComponent, PeriodUpdateComponent, PeriodDeleteDialogComponent, PeriodDeletePopupComponent],
    entryComponents: [PeriodComponent, PeriodUpdateComponent, PeriodDeleteDialogComponent, PeriodDeletePopupComponent],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class Examen2PeriodModule {}
