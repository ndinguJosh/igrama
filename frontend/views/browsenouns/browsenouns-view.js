import { PolymerElement } from '@polymer/polymer/polymer-element';
import { html } from '@polymer/polymer/lib/utils/html-tag';

import '@polymer/iron-icon/iron-icon';
import '@vaadin/vaadin-grid/all-imports';
import '@vaadin/vaadin-ordered-layout/vaadin-horizontal-layout';
import '@vaadin/vaadin-ordered-layout/vaadin-vertical-layout';
import '@vaadin/vaadin-lumo-styles/all-imports';
import '@vaadin/vaadin-icons';

class BrowsenounsView extends PolymerElement {
  _attachDom(dom) {
    // Do not use a shadow root
    this.appendChild(dom);
  }

  static get template() {
    return html`
      <vaadin-grid id="grid" theme="no-border no-row-borders" items="[[items]]">
        <vaadin-grid-column>
          <template>
            <vaadin-horizontal-layout theme="spacing-s" class="card">
              <img src="[[item.image]]" />
              <vaadin-vertical-layout>
                <vaadin-horizontal-layout theme="spacing-s" class="header">
                  <span class="name">[[item.name]]</span>
                  <span class="date">[[item.date]]</span>
                </vaadin-horizontal-layout>
                <span class="post">[[item.post]]</span>
                <vaadin-horizontal-layout theme="spacing-s" class="actions">
                  <iron-icon icon="vaadin:heart"></iron-icon>
                  <span class="likes">[[item.likes]]</span>
                  <iron-icon icon="vaadin:comment"></iron-icon>
                  <span class="comments">[[item.comments]]</span>
                  <iron-icon icon="vaadin:connect"></iron-icon>
                  <span class="shares">[[item.shares]]</span>
                </vaadin-horizontal-layout>
              </vaadin-vertical-layout>
            </vaadin-horizontal-layout>
          </template>
        </vaadin-grid-column>
      </vaadin-grid>
    `;
  }

  static get is() {
    return 'browsenouns-view';
  }
}

customElements.define(BrowsenounsView.is, BrowsenounsView);
