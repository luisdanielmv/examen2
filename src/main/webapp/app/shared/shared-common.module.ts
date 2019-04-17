import { NgModule } from '@angular/core';

import { Examen2SharedLibsModule, JhiAlertComponent, JhiAlertErrorComponent } from './';

@NgModule({
    imports: [Examen2SharedLibsModule],
    declarations: [JhiAlertComponent, JhiAlertErrorComponent],
    exports: [Examen2SharedLibsModule, JhiAlertComponent, JhiAlertErrorComponent]
})
export class Examen2SharedCommonModule {}
