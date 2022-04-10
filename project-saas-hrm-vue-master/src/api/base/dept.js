import { createAPI } from '@/utils/request'

export const list = data => createAPI('company/department', 'get', data)
export const save = data => createAPI('company/department', 'post', data)
export const find = data => createAPI('company/department/{data}', 'get', data)

export const deleteById = data => createAPI('company/department/${data.id}', 'delete', data)
export const update = data => createAPI('company/department/${data.id}', 'put', data)
export const saveOrupdate = data => { return data.id ? update(data) : save(data) }